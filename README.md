# zaoshu-java-sdk
造数(zaoshu.io) api java sdk , api 文档 https://github.com/zaoshu/openapi

### 使用方法

* 钱包
```
    String secret = "...";
    String apiKey = "...";

    ZaoshuClient client = new ZaoshuClient(apiKey,secret);
    Wallet wallet = client.user().wallet();
```
* 爬虫实例列表
```
    String secret = "...";
    String apiKey = "...";

    ZaoshuClient client = new ZaoshuClient(apiKey,secret);
    InstanceList list = client.instance().list();

    list.getData().forEach(data -> {
         //log.info("instance:\n{}",gson.toJson(data));
         //todo
    });
```
* 运行实例
```
    String secret = "...";
    String apiKey = "...";
    String instanceId = "d4351194a41f4526bbada92eff75e743";

    ZaoshuClient client = new ZaoshuClient(apiKey,secret);

    client.instance().run(instanceId,null,null);

```

### 接口完成度

  * [X] 帐户信息
  * [X] 钱包信息
  * [X] 实例列表
  * [X] 实例详情
  * [X] 编辑实例
  * [X] 运行实例
  * [X] 实例任务列表
  * [X] 实例任务详情
