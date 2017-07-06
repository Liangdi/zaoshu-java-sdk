# zaoshu-java-sdk
造数(zaoshu.io) api java sdk , api 文档 https://github.com/zaoshu/openapi

### 使用方法
* 源吗构建
```
    mvn -Dmaven.test.skip=true package
```
* 下载 jar
```
    https://github.com/Liangdi/zaoshu-java-sdk/releases
```
* 本地 jar 包依赖
```
<dependency>
  <groupId>com.github.liangdi</groupId>
  <artifactId>zaoshu-sdk</artifactId>
  <version>1.0-SNAPSHOT</version>
  <type>jar</type>
  <scope>system</scope>
  <systemPath>${basedir}/path/to/jar</systemPath>
</dependency>
```

* 中央仓库依赖 (未完成)
```
<dependency>
  <groupId>com.github.liangdi</groupId>
  <artifactId>zaoshu-sdk</artifactId>
  <version>1.0-SNAPSHOT</version>
</dependency>
```

### 调用接口

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
* 下载 JSON 数据
```
    String instanceId = "d4351194a41f4526bbada92eff75e743";
    String taskId = "e31ccf9a07e143dbbeae61ef7c5e1dcd";

    String json = instanceApi.downloadJsonData(instanceId, taskId);

    log.info("json:\n{}",json);
```

### 接口完成度

  * [X] 帐户信息
  * [X] 钱包信息
  * [X] 实例列表
  * [X] 实例详情
  * [X] 实例数据格式
  * [X] 编辑实例
  * [X] 运行实例
  * [X] 实例任务列表
  * [X] 实例任务详情
  * [X] 下载 JSON 数据
