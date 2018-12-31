package com.xiaoshu.seudcarsmallprograms.mapper;

import com.xiaoshu.seudcarsmallprograms.dto.CarBasicsDto;
import com.xiaoshu.seudcarsmallprograms.model.CarBasics;
import com.xiaoshu.seudcarsmallprograms.util.MyMapper;
import com.xiaoshu.seudcarsmallprograms.vo.CarBasicsVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface CarBasicsMapper extends MyMapper<CarBasics> {

    @Update("UPDATE car_basics SET seller_id = #{sellerId} WHERE id = #{carId}")
    void saveCarBasicsSeller(@Param("carId") Long carId, @Param("sellerId") Long sellerId);

    @Update("UPDATE car_basics SET status = -1 WHERE id = #{id}")
    void under(@Param("id")Long id);

    List<CarBasicsVo> selectListCondition(@Param("params")CarBasicsDto carBasicsDto);

    List<CarBasicsVo> selectAnyListCondition(@Param("params")CarBasicsDto carBasicsDto);
}