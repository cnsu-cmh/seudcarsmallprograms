package com.xiaoshu.seudcarsmallprograms.mapper;

import com.xiaoshu.seudcarsmallprograms.model.CarBasics;
import com.xiaoshu.seudcarsmallprograms.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface CarBasicsMapper extends MyMapper<CarBasics> {

    @Update("UPDATE car_basics SET seller_id = #{sellerId} WHERE id = #{carId}")
    void saveCarBasicsSeller(@Param("carId") Long carId, @Param("sellerId") Long sellerId);

    @Update("UPDATE car_basics SET status = -1 WHERE id = #{id}")
    void under(@Param("id")Long id);
}