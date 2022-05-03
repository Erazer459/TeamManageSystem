package com.Erazer.controller.historyController;

import com.Erazer.ApiResult.R;
import com.Erazer.ApiResult.ResultCode;
import com.Erazer.GlobalExceptionResolver.MyException;
import com.Erazer.pojo.History;
import com.Erazer.service.historyService.historyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Api(tags = "团队历史信息")
@RestController
@RequestMapping("else/history")
public class historyController {
    @Autowired
    historyService historyService;

    @GetMapping("/getAllHistory")
    @ApiOperation(value = "获取所有团队历史事件", notes = "获取所有事件", httpMethod = "GET")
    private R getAllHistory() throws MyException {
        List<History> historyList = historyService.getAllHistory();
        if (historyList.isEmpty()) {
            throw new MyException(ResultCode.GET_ERROR);
        }
        return R.ok().data("items", historyList);
    }

    @PostMapping("/addHistory")
    @ApiOperation(value = "添加历史事件", notes = "添加事件", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "history_edit_time", value = "事件编辑时间", required = true, paramType = "query", dataType = "Date"),
            @ApiImplicitParam(name = "history_info", value = "事件描述信息", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "history_video", value = "事件视频", paramType = "query", dataType = "String")
    })
    private R addHistory(@ApiIgnore History history) throws MyException {
        int flag = historyService.addHistory(history);
        if (flag != 0) {
            return R.ok().data("key", history.getHistory_id());
        }
        throw new MyException(ResultCode.POST_ERROR);
    }

    @DeleteMapping("/deleteHistory")
    @ApiImplicitParam(name = "id", value = "要删除的事件ID", required = true)
    @ApiOperation(value = "删除历史事件", notes = "根据ID删除事件", httpMethod = "DELETE")
    private R deleteHistory(int id) throws MyException {
        int flag = historyService.deleteHistory(id);
        if (flag != 0) {
            return R.ok().data("OK", "删除成功");
        }
        throw new MyException(ResultCode.DELETE_ERROR);
    }

    @PutMapping("/updateHistory")
    @ApiOperation(value = "更新历史事件", notes = "通过ID更新历史事件", httpMethod = "PUT")
    @ApiImplicitParam(name = "id", value = "要更新的事件ID", required = true)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "history_edit_time", value = "事件编辑时间", required = true, paramType = "query", dataType = "Date"),
            @ApiImplicitParam(name = "history_info", value = "事件描述信息", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "history_video", value = "事件视频", paramType = "query", dataType = "String")
    })
    private R updateHistory(int id, @ApiIgnore History history) throws MyException {
        int flag = historyService.updateHistory(id, history);
        if (flag != 0) {
            return R.ok().data("OK", "更新事件成功");
        }
        throw new MyException(ResultCode.UPDATE_ERROR);
    }

    @GetMapping("/getHistoryById")
    @ApiOperation(value = "获取历史事件信息", notes = "通过ID来获取事件信息", httpMethod = "GET")
    @ApiImplicitParam(name = "id", value = "要查询的事件ID", required = true)
    private R getHistoryById(int id) throws MyException {
        History history = historyService.getHistoryById(id);
        if (history != null) {
            return R.ok().data("items", history);
        }
        throw new MyException(ResultCode.GET_ERROR);
    }
}
