package cn.tianjin.unifiedfee.credit.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.taiji.format.PageInfo;
import cn.taiji.format.result.ResponseResult;
import cn.taiji.web.base.controller.BaseApiController;
import cn.tianjin.unifiedfee.credit.domain.XyglEvaluateresult;
import cn.tianjin.unifiedfee.credit.service.XyglUnitepunishService;

/**
 * xx模块数据接口
 *
 */
@RestController
@RequestMapping("/api/credit/xygl-unitepunish")
public class XyglUnitepunishApiController extends BaseApiController {

	@Autowired
	public XyglUnitepunishService xyglUnitepunishService;
	
	/**
	 *  关联查询获取历史明细二级列表
	 * @param pageInfo
	 *            
	 * @return 结果集
	 */
	@PostMapping("/findHistorydetail")
	public ResponseResult getevalHistory(@RequestBody String historyId) {
	    
		return renderSuccess(xyglUnitepunishService.getevalHistory(historyId));
	}

	/**
	 * 获取列表
	 * 
	 * @param pageInfo
	 *            查询条件
	 * @return 结果集
	 */
	@PostMapping("/list")
	public ResponseResult findPage(@RequestBody PageInfo<XyglEvaluateresult> pageInfo) {
		return renderSuccess(xyglUnitepunishService.findPage(pageInfo));
	}

	/**
	 * 根据主键查询数据
	 * 
	 * @param pageInfo
	 *            数据主键
	 * @return 结果集
	 */
	@GetMapping("/{id}")
	public ResponseResult find(@PathVariable("id") String id) {
	    XyglEvaluateresult domain = xyglUnitepunishService.get(id);
		return domain != null ? renderSuccess(domain) : renderError("数据不存在");
	}

	/**
	 * 添加一条数据
	 * 
	 * @param XyglUnitepunish
	 *            实体类
	 * @return 添加结果
	 */
	@PostMapping
	public ResponseResult add(@Valid @RequestBody XyglEvaluateresult domain) {
		domain = xyglUnitepunishService.save(domain);
		return domain != null ? renderSuccess() : renderError("添加失败");
	}

	/**
	 * 更新全部数据
	 * 
	 * @param XyglUnitepunish
	 * @return 更新结果
	 */
	@PutMapping
	public ResponseResult updateAll(@Valid @RequestBody XyglEvaluateresult domain) {
		domain = xyglUnitepunishService.update(domain);
		return domain != null ? renderSuccess() : renderError("更新失败");
	}
	
	/**
	 * 删除一条数据
	 * 
	 * @param id
	 *            数据主键
	 * @return 删除结果
	 */
	@DeleteMapping("/{id}")
	public ResponseResult del(@PathVariable String id) {
		xyglUnitepunishService.delete(id);
		return renderSuccess();
	}
//  /**
//  * 更新部分字段，新建dot类
//  */
//	@PatchMapping
//	public ResponseResult updatePart(@Valid @RequestBody xxxDto dot) {
//		XyglUnitepunish domain = xyglUnitepunishService.get(id);
//		domain.setxxx();
//		//TODO 设置更新值
//		domain = xyglUnitepunishService.update(domain);
//		return domain != null ? renderSuccess() : renderError("更新失败");
//	}
	
}
