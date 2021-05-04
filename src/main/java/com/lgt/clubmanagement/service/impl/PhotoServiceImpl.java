package com.lgt.clubmanagement.service.impl;

import com.lgt.clubmanagement.dao.PhotoMapper;
import com.lgt.clubmanagement.entity.Photo;
import com.lgt.clubmanagement.entity.PhotoExample;
import com.lgt.clubmanagement.entity.PhotoWithBLOBs;
import com.lgt.clubmanagement.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    private PhotoMapper photoMapper;

    @Override
    public int createPhoto(PhotoWithBLOBs photo) {
        return photoMapper.insert(photo);
    }

    @Override
    public int updatePhoto(PhotoWithBLOBs photo) {
        return photoMapper.updateByPrimaryKey(photo);
    }

    @Override
    public int deletePhoto(PhotoWithBLOBs photo) {
        return photoMapper.updateByPrimaryKey(photo);
    }

    @Override
    public List<PhotoWithBLOBs> queryPhotoByAll(int sid) {
        PhotoExample example = new PhotoExample();
        PhotoExample.Criteria criteria = example.createCriteria();
        criteria.andSidEqualTo(sid);
        return photoMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<PhotoWithBLOBs> queryPhotoByExample(PhotoWithBLOBs photo, Date startTime, Date endTime) {
        PhotoExample example = new PhotoExample();
        PhotoExample.Criteria criteria = example.createCriteria();
        criteria.andSidEqualTo(photo.getSid());
        if (photo.getId() != null && !photo.getId().equals("")) {
            criteria.andIdEqualTo(photo.getId());
        }
        if (photo.getStatus() != null && !photo.getStatus().equals("")) {
            criteria.andStatusEqualTo(photo.getStatus());
        }
        if (photo.getName() != null && !photo.getName().equals("")) {
            criteria.andNameLike("%" + photo.getName() + "%");
        }
        if (startTime != null && endTime != null) {
            criteria.andDateBetween(startTime, endTime);
        }
        return photoMapper.selectByExampleWithBLOBs(example);
    }
}
