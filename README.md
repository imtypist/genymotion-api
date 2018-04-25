# genymotion-api

`genymotion-api-1.0.4.jar`的反编译java代码，API参照官方提供的API文档[Genymotion Java API](https://cloud.genymotion.com/static/external/javadoc/index.html)。

### Feature

- 可以作为依赖的Module添加到Android项目中使用或打包成jar包使用
- 可按自己的需求更改API接口

### ChangeLog

- 注释掉了checkToken的License检查
- 在Gps类中增加函数接口`setLocation(final double latitude, final double longitude, final double altitude, final float accuracy, final float bearing)`，解决[issue#10](https://github.com/Genymobile/genymotion-binocle/issues/10)的问题
