#项目接口文档

#项目列表页-按搜索条件展示项目
方法：POST
参数：
name-项目名称
响应：  
```javascript
{
    "message": {
        "code": 200,
        "messageInfo": "ok",
        "serverTime": 1577503483496
    },
    "result": [{
    	name: "用户昵称",
    	icon: "用户头像url",
    	country: "用户国家",
    	lang: "用户语言",
    	time: 23252135125, // like时间，时间戳
    	balance: 1355, // 当前余额
    	amount: 13231 // 历史充值数
    }]
}
```

