# Government-subsystem
WEB&amp;SOA Government subsystem


#### API调用实例
```
//获取社保卡信息
GET http://139.196.194.51:18081/api/patients/all
content-type:application/json
Accept: application/json
```

```
//对社保卡余额进行更新
POST http://139.196.194.51:18081/api/patients/update
content-type:application/json
Accept: application/json

{
  "id":"1214",
  "economy":50
}
```

```
//获取医保卡信息
GET http://139.196.194.51:18081/api/patient2s/all
content-type:application/json
Accept: application/json
```

```
//对医保卡余额进行更新
POST http://139.196.194.51:18081/api/patient2s/update
content-type:application/json
Accept: application/json

{
  "id":"1214",
  "economy":50
}
```
