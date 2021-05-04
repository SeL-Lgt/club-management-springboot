package com.lgt.clubmanagement.service;

import com.lgt.clubmanagement.entity.Photo;
import com.lgt.clubmanagement.entity.PhotoWithBLOBs;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public interface PhotoService {
    /**
     * 添加照片
     *
     * @param photo
     * @return
     */
    int createPhoto(PhotoWithBLOBs photo);

    /**
     * 修改照片信息
     *
     * @param photo
     * @return
     */
    int updatePhoto(PhotoWithBLOBs photo);

    /**
     * 删除照片信息
     *
     * @param photo
     * @return
     */
    int deletePhoto(PhotoWithBLOBs photo);

    /**
     * 查询社团照片
     *
     * @param sid
     * @return
     */
    List<PhotoWithBLOBs> queryPhotoByAll(int sid);

    /**
     * 根据条件查询社团照片
     *
     * @param photo
     * @return
     */
    List<PhotoWithBLOBs> queryPhotoByExample(PhotoWithBLOBs photo, Date startTime, Date endTime);
}
