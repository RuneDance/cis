package com.oa.cis.mapper;

import com.oa.cis.entity.Form;
import com.oa.cis.vo.FormVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FormMapper {
    //历史表单信息
    Form selectByFormByFormVo(FormVo formVo);

}