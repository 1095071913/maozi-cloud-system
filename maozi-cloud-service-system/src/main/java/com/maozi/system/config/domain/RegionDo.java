package com.maozi.system.config.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.TableComment;
import com.maozi.base.AbstractBaseDomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@TableName("system_config_region")
@TableComment("地区")
public class RegionDo extends AbstractBaseDomain {
	
	@Column(value = "parent_id",comment = "父级ID",defaultValue = "1")
	private Long parentId;
	
	@Column(value = "sname",comment = "简称")
	private String sname;
	
	@Column(value = "level",comment = "级别")
	private Integer level;
	
	@Column(value = "city_code",comment = "编码")
	private String cityCode;
	
	@Column(value = "mail_code",comment = "邮政编码")
	private String mailCode;
	
	@Column(value = "mername",comment = "组合名称")
	private String mername;
	
	@Column(value = "Lng",comment = "经度")
	private Float Lng;
	
	@Column(value = "Lat",comment = "维度")
	private Float Lat;
	
	@Column(value = "pinyin",comment = "拼音")
	private String pinyin;

}
