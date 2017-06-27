package me.liangdi.zaoshu.api;

import me.liangdi.zaoshu.Constant;
import me.liangdi.zaoshu.model.*;
import me.liangdi.zaoshu.util.HttpUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * doc https://github.com/zaoshu/openapi/blob/master/v2/zh-CN/instance.md
 * Created by liangdi on 6/27/17.
 */
public class InstanceApi extends AbstractApi{
    // GET
    private String instanceListUrl = Constant.API_URL +  "/instances";

    // GET-> :id    PATCH-> :id  edit instance  POST-> :id  run instance
    private String instanceUrl = Constant.API_URL + "/instance/:instance_id";

    private String taskListUrl =Constant.API_URL +  "/instance/:instance_id/tasks";

    private String taskUrl = Constant.API_URL + "/instance/:instance_id/task:task_id";

    /**
     * 实例列表
     * @return
     */
    public InstanceList list(){
        InstanceList list = new InstanceList();
        String result = HttpUtil.get(keyPair,  instanceListUrl);
        if(StringUtils.isNotEmpty(result)) {
            list = gson.fromJson(result,InstanceList.class);
        }
        return list;
    }

    /**
     * 获得 ID 对应实例详情
     * @param id
     * @return
     */
    public Instance get(String id){
        Instance instance = new Instance();
        String result = HttpUtil.get(keyPair,  instanceUrl.replaceAll(":instance_id",id));
        if(StringUtils.isNotEmpty(result)) {
            instance = gson.fromJson(result,Instance.class);
        }
        return instance;
    }

    /**
     * 获取实例的任务列表
     * @param instanceId
     * @return
     */
    public TaskList taskList(String instanceId){
        TaskList taskList = new TaskList();
        String result = HttpUtil.get(keyPair,  taskListUrl.replaceAll(":instance_id",instanceId));
        if(StringUtils.isNotEmpty(result)) {
            taskList = gson.fromJson(result,TaskList.class);
        }
        return taskList;
    }

    /**
     * 获取任务详情
     * @param instanceId
     * @param taskId
     * @return
     */
    public Task getTask(String instanceId, String taskId) {
        Task task = new Task();
        String result = HttpUtil.get(keyPair,
                taskUrl.replaceAll(":instance_id",instanceId)
                        .replaceAll(":task_id",taskId));
        if(StringUtils.isNotEmpty(result)) {
            task = gson.fromJson(result,Task.class);
        }
        return task;
    }

    /**
     * 运行实例
     * @param id
     * @return
     */
    public ApiResult run(String id,RunConfig config,String notifyUri){
        //todo
        throw new UnsupportedOperationException();
    }

    /**
     * 编辑实例
     * @param id
     * @param title
     * @param notifyUri
     * @return
     */
    public ApiResult edit(String id,String title,String notifyUri){
        //todo
        throw new UnsupportedOperationException();
    }

}
