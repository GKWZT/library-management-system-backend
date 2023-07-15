package com.example.mapper;

import com.example.entity.RestBean;
import com.example.entity.auth.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author wzt
 */
@Mapper
public interface BookMapper {

    @Insert("insert into db_book (isbn, category, author, press, description) values (#{isbn}, #{category}, #{author}, #{press}, #{description})")
    int createBook(long isbn, String category, String author, String press, String description);

    @Select("select * from db_book")
    List findBookAll();

    @Select("select * from db_book where id = #{id}")
    Account findBookById(long id);

    /**
     * id: 书的id
     *
     * */
    @Update("update db_book set isbn = #{isbn} where id = #{id}")
    int updateBookById(long id,long isbn);
}
