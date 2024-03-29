package com.guyuu.baike.mappers;

import com.guyuu.baike.model.WikiCatalogHistory;
import com.guyuu.baike.model.WikiCatalogHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WikiCatalogHistoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guu_wiki_entry_catalog_history
     *
     * @mbggenerated Mon Jun 09 01:27:10 CST 2014
     */
    int countByExample(WikiCatalogHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guu_wiki_entry_catalog_history
     *
     * @mbggenerated Mon Jun 09 01:27:10 CST 2014
     */
    int deleteByExample(WikiCatalogHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guu_wiki_entry_catalog_history
     *
     * @mbggenerated Mon Jun 09 01:27:10 CST 2014
     */
    int deleteByPrimaryKey(String historyId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guu_wiki_entry_catalog_history
     *
     * @mbggenerated Mon Jun 09 01:27:10 CST 2014
     */
    int insert(WikiCatalogHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guu_wiki_entry_catalog_history
     *
     * @mbggenerated Mon Jun 09 01:27:10 CST 2014
     */
    int insertSelective(WikiCatalogHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guu_wiki_entry_catalog_history
     *
     * @mbggenerated Mon Jun 09 01:27:10 CST 2014
     */
    List<WikiCatalogHistory> selectByExampleWithBLOBs(WikiCatalogHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guu_wiki_entry_catalog_history
     *
     * @mbggenerated Mon Jun 09 01:27:10 CST 2014
     */
    List<WikiCatalogHistory> selectByExample(WikiCatalogHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guu_wiki_entry_catalog_history
     *
     * @mbggenerated Mon Jun 09 01:27:10 CST 2014
     */
    WikiCatalogHistory selectByPrimaryKey(String historyId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guu_wiki_entry_catalog_history
     *
     * @mbggenerated Mon Jun 09 01:27:10 CST 2014
     */
    int updateByExampleSelective(@Param("record") WikiCatalogHistory record, @Param("example") WikiCatalogHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guu_wiki_entry_catalog_history
     *
     * @mbggenerated Mon Jun 09 01:27:10 CST 2014
     */
    int updateByExampleWithBLOBs(@Param("record") WikiCatalogHistory record, @Param("example") WikiCatalogHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guu_wiki_entry_catalog_history
     *
     * @mbggenerated Mon Jun 09 01:27:10 CST 2014
     */
    int updateByExample(@Param("record") WikiCatalogHistory record, @Param("example") WikiCatalogHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guu_wiki_entry_catalog_history
     *
     * @mbggenerated Mon Jun 09 01:27:10 CST 2014
     */
    int updateByPrimaryKeySelective(WikiCatalogHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guu_wiki_entry_catalog_history
     *
     * @mbggenerated Mon Jun 09 01:27:10 CST 2014
     */
    int updateByPrimaryKeyWithBLOBs(WikiCatalogHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guu_wiki_entry_catalog_history
     *
     * @mbggenerated Mon Jun 09 01:27:10 CST 2014
     */
    int updateByPrimaryKey(WikiCatalogHistory record);
}