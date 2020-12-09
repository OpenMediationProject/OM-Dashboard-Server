// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmUpload;
import com.adtiming.om.ds.model.OmUploadCriteria;
import java.util.List;

public interface OmUploadMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OmUpload record);

    int insertSelective(OmUpload record);

    List<OmUpload> select(OmUploadCriteria criteria);

    OmUpload selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OmUpload record);

    int updateByPrimaryKey(OmUpload record);
}