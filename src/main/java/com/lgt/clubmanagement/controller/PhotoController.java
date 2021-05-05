package com.lgt.clubmanagement.controller;

import com.lgt.clubmanagement.entity.Photo;
import com.lgt.clubmanagement.entity.PhotoWithBLOBs;
import com.lgt.clubmanagement.entity.Userinfo;
import com.lgt.clubmanagement.service.PhotoService;
import com.lgt.clubmanagement.service.UserService;
import com.lgt.clubmanagement.utils.DateUtil;
import com.lgt.clubmanagement.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

@Api(tags = "相册管理")
@RestController
@RequestMapping(value = "photo", produces = "application/json")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @Autowired
    private UserService userService;

    @ResponseBody
    @ApiOperation(value = "上传相册")
    @PostMapping("saveImage")
    public JsonResult saveImage(String image, PhotoWithBLOBs photo, String type) {
        try {
            System.out.println(image);
            System.out.println(photo.toString());
            //输出base64 数据,截取","之后的值进行转换
            String str = image.substring(image.indexOf(",") + 1);
            //System.currentTimeMillis()意思是获取当前系统的时间戳给图片命名
            //实例化Base64转换类  调用里面的GenerateImage方法（把base64数据转为图片）
            //第一个参数base64转图片的必须的base64数据，第二个是转换后生成的图片存放路径
            String imageName = System.currentTimeMillis() + "." + type;
            String imagePath = "D:/images/" + imageName;
            GenerateImage(str, imagePath, type);
            //数据库存入绝对路径下的图片路径及名称（上传图片即是修改操作）
            Date data = new Date();
            photo.setDate(DateUtil.parseDate(DateUtil.format(data, DateUtil.DEFAULT_FORMAT), DateUtil.DEFAULT_FORMAT));
            photo.setPath(imageName);
            photoService.createPhoto(photo);

            return JsonResult.success("", "创建成功");
        } catch (Exception e) {
            return JsonResult.error(e, "服务器报错");
        }
    }

    @ApiOperation(value = "查询社团照片")
    @PostMapping("queryPhotoByAll")
    public JsonResult queryPhotoByAll(int sid) {
        try {
            List<PhotoWithBLOBs> list = photoService.queryPhotoByAll(sid);
            for (PhotoWithBLOBs p : list) {
                Userinfo userinfo = userService.queryUserById(p.getUid());
                p.setUserinfo(userinfo);
            }
            return JsonResult.success(list, "查询成功");
        } catch (Exception e) {
            return JsonResult.error(e, "服务器报错");
        }
    }

    @ApiOperation(value = "模糊查询照片")
    @PostMapping("queryPhotoByExample")
    public JsonResult queryPhotoByExample(String name, Integer sid, String startTime, String endTime,Integer status) {
        try {
            Date start = null;
            Date end = null;
            if (startTime != null && !startTime.equals("")) {
                start = DateUtil.parseDate(startTime, DateUtil.DEFAULT_FORMAT);
            }
            if (endTime != null && !endTime.equals("")) {
                end = DateUtil.parseDate(endTime, DateUtil.DEFAULT_FORMAT);
            }
            PhotoWithBLOBs photo = new PhotoWithBLOBs();
            photo.setName(name);
            photo.setSid(sid);
            photo.setStatus(status);
            List<PhotoWithBLOBs> list = photoService.queryPhotoByExample(photo, start, end);
            for (PhotoWithBLOBs p : list) {
                Userinfo userinfo = userService.queryUserById(p.getUid());
                p.setUserinfo(userinfo);
            }
            return JsonResult.success(list, "查询成功");
        } catch (Exception e) {
            return JsonResult.error(e, "服务器报错");
        }
    }

    @ApiOperation(value = "更新照片")
    @PostMapping("updatePhoto")
    public JsonResult updatePhoto(PhotoWithBLOBs photo) {
        try {
            int count = photoService.updatePhoto(photo);
            return JsonResult.success(count, "更新成功");
        } catch (Exception e) {
            return JsonResult.error(e, "更新失败");
        }
    }

    @ApiOperation(value = "删除照片")
    @PostMapping("deletePhoto")
    public JsonResult deletePhoto(Integer id) {
        try {
            int count = photoService.deletePhoto(id);
            return JsonResult.success(count, "删除成功");
        } catch (Exception e) {
            return JsonResult.error(e, "删除失败");
        }
    }


    //base64字符串转化成图片
    public static boolean GenerateImage(String imgStr, String imageName, String type) {
        //对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) //图像数据为空
            return false;
        try {
            //Base64解码
            byte[] b = Base64.decodeBase64(imgStr.replace("data:image/" + type + ";base64,", ""));
            imgStr = imgStr.replace("base64,", "");
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    //调整异常数据
                    b[i] += 256;
                }
            }
            //生成jpeg图片
            String imgFilePath = imageName;//新生成的图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
