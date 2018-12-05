package com.ujiuye.mapper;

import com.ujiuye.bean.Product;
import com.ujiuye.bean.ProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    int countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
    
    
    List<Product> getHot();
    
    List<Product> getNew();
    
    List<Product> showPage(int cid);
    
    Product getOne(int pid);
    
    List<Product> sreachPro(String sreachinfo);
    
    List<Product> limitProList(@Param("start")int start,@Param("pagesize")int pagesize);
    
    int getCount();
}