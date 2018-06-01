package com.joe.mybatis.service.impl;

import com.joe.mybatis.controller.TestController;
import com.joe.mybatis.mapper.ZcdcMapper;
import com.joe.mybatis.model.PageDo;
import com.joe.mybatis.model.Zcdc;
import com.joe.mybatis.service.ZcdcService;
import com.joe.mybatis.util.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ZcdcServiceImpl implements ZcdcService {

	private static Logger LOG = LoggerFactory.getLogger(TestController.class);

	@Resource
	private ZcdcMapper zcdcZxMapper;

	@Override
	public int insert(Zcdc zcdcZx) {
		return zcdcZxMapper.insert(zcdcZx);
	}

	@Override
	public int update(Zcdc zcdcZx) {
		return zcdcZxMapper.updateByPrimaryKeySelective(zcdcZx);
	}

	@Override
	public int deleteByIdList(List<String> idList) {
		return zcdcZxMapper.deleteByPrimaryKeyList(idList);
	}

	@Override
	public Zcdc queryById(String id) {
		return zcdcZxMapper.selectByPrimaryKey(id);
	}

	@Override
	public void findDataGrid(PageDo pageDo) {
		pageDo.setRows(zcdcZxMapper.findPageDo(pageDo));
		pageDo.setTotal(zcdcZxMapper.findPageDoCount(pageDo));
	}

	@Override
	public String createZxCode() {
		String zxCode = zcdcZxMapper.queryMaxZxCode();
		if(StringUtils.isBlank(zxCode)){
			zxCode = DateUtil.getTime4yyyyMMdd() + "-001";
		}else{
			String dateStr = zxCode.substring(0,zxCode.indexOf("-"));
			if(DateUtil.getTime4yyyyMMdd().equals(dateStr)){
				String tempStr = zxCode.substring(zxCode.indexOf("-")+1,zxCode.length());
				Integer temp = Integer.parseInt(tempStr);
				temp++;
				String code = temp < 999 ? (temp < 10 ? ("00" + temp) : (temp < 100 ? "0" + temp : "" + temp)) : temp+"";
				zxCode = DateUtil.getTime4yyyyMMdd() + "-" + code;
			}else {
				zxCode = DateUtil.getTime4yyyyMMdd() + "-001";
			}
		}
		return zxCode;
	}

	@Override
	public int stopZX(List<String> idList) {
		return zcdcZxMapper.updateStatusu2Stop(idList);
	}

	@Override
	public void testTransactionManagement() {
		Zcdc zcdcZx = new Zcdc();
		zcdcZx.setZxUuid("A");
		insert(zcdcZx);
		if(true){
			throw new RuntimeException();
		}
		zcdcZx.setZxUuid("B");
		insert(zcdcZx);
	}
}