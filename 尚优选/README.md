# 项目介绍

![image-20221121030028807](images\image-20221121030028807.png)

![image-20221121030402892](images\image-20221121030402892.png)

# 项目流程

## 1.头部导航栏布局

### 实现
index.html
```html
<!-- 上面部分 -->
<div class="headTop">
    <!-- 版心元素 -->
    <div class="headTopMain">
        <!-- 左侧 -->
        <div class="left">
            <h5>欢迎来到尚优选！ 请</h5>
            <p>
                <a href="javascript:;">登录</a>
                <a href="javascript:;">注册</a>
            </p>
        </div>
        <!-- 左侧结束 -->
        <!-- 右侧 -->
        <div class="right">
            <!-- 导航 -->
            <nav>
                <a href="javascript:;">我的订单</a>
                <a href="javascript:;">我的购物车</a>
                <a href="javascript:;">我的尚优选</a>
                <a href="javascript:;">尚优选会员</a>
                <a href="javascript:;">企业采购</a>
                <a href="javascript:;">关注尚优选</a>
                <a href="javascript:;">合作招商</a>
                <a href="javascript:;">商家后台</a>
            </nav>
            <!-- 导航结束 -->
        </div>
        <!-- 右测结束 -->
    </div>
    <!-- 版心元素结束 -->
</div>
<!-- 上面部分结束 -->
```

index.less

```less
//上面部分
.headTop {
    background-color: #eaeaea;
    height: 30px;
    // 版心元素
    .headTopMain {
        width: 1200px;
        margin: 0 auto;
        line-height: 30px;
        .clearfix();
        // 左侧
        .left {
            float: left;
            h5 {
                float: left;
            }                      
            p {
                float: left;
                a {
                    &:first-child{
                        border-right: 1px solid #b3aeae;
                        padding-right: 5px;
                    }
                }
            }
        }
        // 左侧结束
        //右侧
        .right{
            float: right;
            //导航
            nav{
                font-size: 0px;
                //在书写行内元素a时如果进行了换行，浏览器会将换行渲染成空格，
                // 此时会产生样式的问题，因为多了一个空格。
                // 解决办法：在a元素的父级元素nav中，将字体大小设为0，
                // 这样nav内部就变成了空白，然后在a元素中还原字体大小，这样就删掉了空格。

                a{
                    font-size: 12px;
                    border-right: 1px solid #b3aeae;
                    margin-right: 10px;
                    padding-right: 10px;

                    &:last-child {
                        border: none;
                        margin: 0;
                        padding: 0;
                    }
                }
            }
            //导航结束
        }
        //右侧结束
    }
    //版心元素结束
}
//上面部分结束
```

### 此部分收获

在书写行内元素a时如果进行了换行，浏览器会将换行渲染成空格，此时会产生样式的问题，因为多了一个空格。
解决办法：在a元素的父级元素nav中，将字体大小设为0，这样nav内部就变成了空白，然后在a元素中还原字体大小，这样就删掉了空格。

## 2.头部搜索布局

### 实现

index.html

```html
<!-- 下面部分 -->
<div class="headBottom">
    <!-- 版心元素 -->
    <div class="headBottomMain">
        <!-- logo -->
        <h1 class="logo">
            <a href="javascript">
                <img src="./images/logo.png" alt="">
            </a>
        </h1>
        <!-- logo结束 -->
        <!-- 搜索框 -->
        <div class="search">
            <input type="text" placeholder="请输入搜索内容">
            <input type="submit" value="提交">
        </div>
        <!-- 搜索框结束 -->
    </div>
    <!-- 版心元素结束 -->
</div>
<!-- 下面部分结束 -->
```

index.less

```less
//下面部分
.headBottom{
    //版心元素
    .headBottomMain{
        width: 1200px;
        margin: 0 auto;
        .clearfix();
        //logo
        .logo{
            float: left;
            a{
                img{
                    width: 175px;
                    height: 56px;
                    margin: 25px 45px;
                }
            }
        }
        //logo结束
        //搜索框
        .search{
            float: right;
            margin-top: 35px;
            input{
                //文本框
                &:first-child{
                    box-sizing: border-box;
                    width: 490px;
                    height: 32px;
                    padding: 0 4px;
                    border: 3px solid #ea4a36;
                    float: left;
                }
                //提交按钮
                &:last-child{
                    width: 68px;
                    height: 32px;
                    color: #fff;
                    background-color: #ea4a36;
                    border: none;
                }
                //修饰placeholder
                &::-webkit-input-placeholder{
                    color: yellowgreen;
                }
            }
        }
        //搜索框结束
    }
    //版心元素结束
}
//下面部分结束
```

### 此部分收获

复习了`box-sizing`，新收获如何修饰placeholder

## 3.商品导航分类布局

### 实现

index.html

```html
<!-- 分类导航 -->
<div id="navWrap">
    <!-- 版心元素 -->
    <div class="navWrapMain">
        <a href="javascript:;">全部商品分类</a>
        <a href="javascript:;">服装城</a>
        <a href="javascript:;">美妆馆</a>
        <a href="javascript:;">尚优选超市</a>
        <a href="javascript:;">全球购</a>
        <a href="javascript:;">闪购</a>
        <a href="javascript:;">团购</a>
        <a href="javascript:;">有趣</a>
        <a href="javascript:;">秒杀</a>
    </div>
</div>
<!-- 分类导航结束 -->
```

index.less

```less
//分类导航 
#navWrap {
    border-bottom: 2px solid #e1251b;
    //版心元素
    .navWrapMain {
        width: 1200px;
        margin: 0 auto;
        .clearfix();
        a {
            margin: 0 22px;
            font-size: 16px;
            color: #333;
            float: left;
            line-height: 50px;
            text-align: center;
            &:first-child {
                width: 210px;
                height: 50px;
                background-color: #e1251b;
                color: #fff;
                font-size: 14px;
                font-weight: bold;
            }
        }
    }
    //版心元素结束
}
//分类导航结束
```

### 此部分不足

- 老师的a标签是直接使用的，暴露太多a标签会影响网站的权重，在完成完整项目后我会使用无序列表包裹
- 老师对当前页的样式是选择了第一个孩子，这里应该是点击了谁，谁的样式就应该是这个。完成完整项目后，考虑将被点击元素添加一个属性。

## 4.路径导航布局

### 实现

index.html

```html
<!-- 内容区域 -->
<div id="content">
    <!-- 版心元素 -->
    <div class="contentMain">
        <!--路径导航 -->
        <div class="navPath">
            <a href="javascript:;">手机、数码、通讯</a>
            <i>/</i>
            <a href="javascript:;">手机</a>
            <i>/</i>
            <a href="javascript:;">Apple苹果</a>
            <i>/</i>
            <a>iphone 6S系</a>
        </div>
        <!--路径导航结束-->
    </div>
    <!-- 版心元素结束 -->
</div>
<!-- 内容区域结束 -->
```

index.less

```less
//内容区域
#content{
    // 版心元素
    .contentMain{
        width: 1200px;
        margin: 15px auto 0 auto;
        // 路径导航
        .navPath{
            padding: 9px 15px 9px 0;
            font-size: 0px;
            a{
                font-size: 12px;
            }
            i{
                padding: 0 5px;
                font-size: 12px;
            }

        }
        // 路径导航结束
    }
    // 版心元素结束
}
//内容区域结束
```

### 此部分收获

再次复习了：行内元素之间空隙的去除

## 5.路径导航数据动态渲染

路径导航的数据应通过类似于json的对象动态获取

### 准备data数据

data.js

```js
var goodData = {
    path: [
        {
            title: "手机、数码、通讯",
            url: "javascript:;"
        }, {
            title: "手机",
            url: "javascript:;"
        }, {
            title: "Apple苹果",
            url: "javascript:;"
        }, {
            title: "iphone 6S系",
        }
    ],
    imagessrc: [
        { b: "./images/b1.png", s: "./images/s1.png" },
        { b: "./images/b2.png", s: "./images/s2.png" },
        { b: "./images/b3.png", s: "./images/s3.png" },
        { b: "./images/b1.png", s: "./images/s1.png" },
        { b: "./images/b2.png", s: "./images/s2.png" },
        { b: "./images/b3.png", s: "./images/s3.png" },
        { b: "./images/b1.png", s: "./images/s1.png" },
        { b: "./images/b2.png", s: "./images/s2.png" },
        { b: "./images/b3.png", s: "./images/s3.png" },
        { b: "./images/b1.png", s: "./images/s1.png" },
        { b: "./images/b2.png", s: "./images/s2.png" },
        { b: "./images/b3.png", s: "./images/s3.png" },
        { b: "./images/b1.png", s: "./images/s1.png" },
        { b: "./images/b2.png", s: "./images/s2.png" }
    ],
    goodsDetail: {
        title: "Apple iPhone 6s（A1700）64G玫瑰金色 移动通信电信4G手机bbb123",
        recommend: "推荐选择下方[移动优惠购],手机套餐齐搞定,不用换号,每月还有花费返",
        price: 5299,
        promoteSales: {
            type: "加价购",
            content: "满999.00另加20.00元，或满1999.00另加30.00元，或满2999.00另加40.00元，即可在购物车换购热销商品"
        },
        support: "以旧换新，闲置手机回收 4G套餐超值抢 礼品购",
        address: "广东省 深圳市 宝安区",
        evaluateNum: 670000,
        crumbData: [
            {
                "title": "选择颜色",
                "data": [
                    {
                        type: "金色",
                        changePrice: 0
                    },
                    {
                        type: "银色",
                        changePrice: 40
                    },
                    {
                        type: "黑色",
                        changePrice: 90
                    },
                ]
            },
            {
                "title": "内存容量",
                "data": [
                    {
                        type: "16G",
                        changePrice: 0
                    },
                    {
                        type: "64G",
                        changePrice: 300
                    },
                    {
                        type: "128G",
                        changePrice: 900
                    },
                    {
                        type: "256G",
                        changePrice: 1300
                    },
                ]
            },
            {
                "title": "选择版本",
                "data": [
                    {
                        type: "公开版",
                        changePrice: 0
                    },
                    {
                        type: "移动版",
                        changePrice: -1000
                    }
                ]
            },
            {
                "title": "购买方式",
                "data": [
                    {
                        type: "官方标配",
                        changePrice: 0
                    },
                    {
                        type: "优惠移动版",
                        changePrice: -240
                    },
                    {
                        type: "电信优惠版",
                        changePrice: -390
                    },
                ]
            }
        ]
    }
}
```

### 动态渲染

index.js

```js
//函数能在前面调用是因为预解析提升
navPathDataBind()
//路径导航动态渲染
function navPathDataBind() {
    //1.获取页面导航的DOM元素
    const navPath = document.querySelector('#wrapper #content .contentMain .navPath')
    //2.获取path数据
    const path = goodData.path
    //3.遍历数据
    for (let i = 0; i < path.length; i++) {
        if (i === path.length - 1) {
            let aNode = document.createElement('a')
            aNode.innerText = path[i].title
            navPath.appendChild(aNode)
        } else {
            //4.创建a标签
            let aNode = document.createElement('a')
            aNode.href = path[i].url
            aNode.innerText = path[i].title
            //5.创建i标签
            let iNode = document.createElement('i')
            iNode.innerText = '/'
            //6.让navPath追加a和i
            navPath.appendChild(aNode)
            navPath.appendChild(iNode)
        }
    }
}
```

## 6.左侧放大镜布局

### 实现

index.html

```html
<!-- 左侧放大镜 -->
<div class="left">
    <!-- 上面 -->
    <div class="leftTop">
        <!-- 小图框 -->
        <div class="smallPic">
            <!-- 小图片 -->
            <img src="./images/s1.png" alt="">
            <!-- 蒙版元素 -->
            <div class="mask"></div>
        </div>
        <!-- 小图框结束 -->
        <!-- 大图框 -->
        <div class="bigPic">
            <!-- 大图片 -->
            <img src="./images/b1.png" alt="">
        </div>
        <!-- 大图框结束 -->
    </div>
    <!-- 上面结束 -->
</div>
<!-- 左侧放大镜结束 -->
```

index.less

```less
//左侧放大镜
.left{
    width: 400px;
    float: left;
    //上面
    .leftTop{
        width: 400px;
        position: relative;
        // 小图框
        .smallPic{
            width: 400px;
            height: 400px;
            border: 1px solid #dfdfdf;
            position: relative;
            // 小图片
            img{

            }
            // 蒙版元素
            .mask{
                width: 200px;
                height: 200px;
                background: rgba(255, 255, 255, .5);
                border: 1px solid #ddd;
                position: absolute;
                top: 0;
                left: 0;
            }
        }
        // 小图框结束
        //大图框
        .bigPic{
            width: 400px;
            height: 400px;
            border: 1px solid #ddd;
            left: 420px;
            top: 0px;
            position: absolute;
            overflow: hidden;
            //大图片
            img{
               width: 800px;
               height: 800px;
            }
        }
        //大图框结束

    }
    //上面结束

}
//左侧放大镜结束
```

### 此部分收获

复习了绝对定位和相对定位

## 7.放大镜鼠标移入移出效果

### 实现

index.js

```js
bigClassBind()
// 放大镜移入移出效果
function bigClassBind(){
    //获取小图框元素
    const smallPic = document.querySelector('#wrapper #content .contentMain .center .left .leftTop .smallPic')
    //获取leftTop元素
    const leftTop = document.querySelector('#wrapper #content .contentMain .center .left .leftTop')
    //设置移入事件
    smallPic.onmouseenter = function(){
        //创建蒙版元素
        let maskDiv = document.createElement('div')
        maskDiv.className = 'mask'
        //创建大图框元素
        let bigPic = document.createElement('div')
        bigPic.className = 'bigPic'
        //创建大图片元素
        let bigImg = document.createElement('img')
        bigImg.src = './images/b1.png'
        //大图框追加大图片
        bigPic.appendChild(bigImg)
        //小图框追加蒙版元素
        smallPic.appendChild(maskDiv)
        //获取leftTop元素追加大图框
        leftTop.appendChild(bigPic)
        //设置鼠标移出事件
        smallPic.onmouseleave = function(){
            //移出蒙版
            smallPic.removeChild(maskDiv)
            //移出大图框
            leftTop.removeChild(bigPic)
        }
    }
}
```

### 此部分收获

`onmouseover`有事件冒泡效果，而`onmouseenter`没有

`removeChild`调用者和参数必须是直接父子关系，否则报错

## 8.放大镜鼠标移动实现蒙版元素的拖拽效果

### 实现

index.js

```js
//设置移动事件
smallPic.onmousemove = function () {
    //左侧位置 = 鼠标距离屏幕左侧的位置 - 小图距离屏幕左侧的距离 - 蒙版宽度的一半
    let left = event.clientX - smallPic.getBoundingClientRect().left - maskDiv.offsetWidth / 2;
    //上侧位置 = 鼠标距离屏幕上侧的位置 - 小图距离屏幕上侧的距离 - 蒙版宽度的一半
    let top = event.clientY - smallPic.getBoundingClientRect().top - maskDiv.offsetHeight / 2;
    //边界控制
    if(left < 0){
        left = 0;
    }else if(left > smallPic.clientWidth - maskDiv.offsetWidth){
        left = smallPic.clientWidth - maskDiv.offsetWidth
    }
    if(top < 0){
        top = 0;
    }else if(top > smallPic.clientHeight - maskDiv.offsetHeight){
        top = smallPic.clientHeight - maskDiv.offsetHeight
    }
    maskDiv.style.left = left + 'px';
    maskDiv.style.top = top + 'px';
}
```

### 此部分收获

- getBoundingClientRect()是DOM元素到浏览器可视范围的距离
- offsetWidth 水平方向 width + 左右padding + 左右border-width
- offsetHeight 垂直方向 height + 上下padding + 上下border-width
- clientWidth 水平方向 width + 左右padding
- clientHeight 垂直方向 height + 上下padding

## 9.放大镜鼠标移动实现大图元素等比例移动效果

### 实现

```js
//大图移动
//移动比 = 蒙版的位置/大图的位置 = (小图的宽度-蒙版的宽度)/(大图片的宽度-大图框的宽度);
let scale = (smallPic.clientWidth - maskDiv.offsetWidth) / (bigImg.offsetWidth - bigPic.clientWidth)
bigImg.style.left = -left / scale + 'px';
bigImg.style.top = -top / scale + 'px';
```

记得给大图片开启绝对定位

## 10.放大镜缩略图布局

### 实现

index.html

```html
<!-- 下面 -->
<div class="leftBottom">
    <a href="javascript:;">< </a>
    <div class="picList" class="prev">
        <ul>
            <li>
                <img src="./images/s1.png" alt="">
            </li>
            <li>
                <img src="./images/s1.png" alt="">
            </li>
            <li>
                <img src="./images/s1.png" alt="">
            </li>
            <li>
                <img src="./images/s1.png" alt="">
            </li>
            <li>
                <img src="./images/s1.png" alt="">
            </li>
            <li>
                <img src="./images/s1.png" alt="">
            </li>
        </ul>
    </div>
    <a href="javascript:;" class="next"> > </a>
</div>
<!-- 下面结束 -->
```

index.less

```less
//下面
.leftBottom {
    a {
        float: left;
        width: 10px;
        height: 54px;
        border: 1px solid #ccc;
        background-color: #ebebeb;
        text-align: center;
        line-height: 54px;
        &:first-child{
            margin-right: 4px;
        }
    }
    .picList {
        float: left;
        width: 372px;
        height: 56px;
        overflow: hidden;
        ul {
            white-space: nowrap;
            font-size: 0px;
            li {
                display: inline-block;
                width: 50px;
                height: 50px;
                border: 1px solid #ccc;
                padding: 2px;
                margin-right: 20px;
                img{
                    width: 50px;
                    height: 50px;
                }
            }
        }
    }
}
//下面结束        
```

### 此部分收获

`white-space: nowrap` 不换行

## 11.放大镜缩略图数据动态渲染

### 实现

```js
thumbnailData()
//动态渲染放大镜缩略图的数据
function thumbnailData() {
    // 获取picList下的ul
    const ul = document.querySelector('#wrapper #content .contentMain .center .left .leftBottom .picList ul')
    //获取imagessrc数据
    let imagesSrc = goodData.imagessrc
    for (let i = 0; i < imagesSrc.length; i++) {
        //创建li元素
        let newLi = document.createElement('li')
        //创建img元素
        let newImg = document.createElement('img')
        newImg.src = imagesSrc[i].s
        //li追加img元素
        newLi.appendChild(newImg);
        //ul追加li元素
        ul.appendChild(newLi)
    }
}
```

## 12.点击缩略图实现换小图以及大图效果

### 实现

我这里和老师的实现方法不一样。因为我不想在全局作用域上有太多变量

```js
//给之前这个方法加个参数，这样就能传参数过来了
function bigClassBind(url) {
    //获取imagessrc数据
    const imagesSrc = goodData.imagessrc
    //改变当时创建大图片的属性值
     bigImg.src = url == undefined ? imagesSrc[0].b : url
}
thumbnailClick();
//点击缩略图效果
function thumbnailClick() {
    //获取所有li元素
    const liNodes = document.querySelectorAll('#wrapper #content .contentMain .center .left .leftBottom .picList ul li')
    //获取imagessrc数据
    const imagesSrc = goodData.imagessrc
    //获取小图元素
    const smallImg = document.querySelector('#wrapper #content .contentMain .center .left .leftTop .smallPic img')
    //小图的默认图片与缩略图第一张图片一致
    smallImg.src = imagesSrc[0].s;
    for (let i = 0; i < liNodes.length; i++) {
        liNodes[i].onclick = function () {
            //大图下标变化
            smallImg.src = imagesSrc[i].s;
            //大图下标变化
            bigClassBind(imagesSrc[i].b)
        }
    }
}
```

### 此部分所感

发现了data.js里的数据经常使用，后期将提出到全局作用域共享

## 13.点击缩略图左右箭头效果

### 实现

```js
thumbnailLeftRightClick()
//点击缩略图左右箭头效果
function thumbnailLeftRightClick() {
    //获取箭头元素
    const prev = document.querySelector('#wrapper #content .contentMain .center .left .leftBottom .prev')
    const next = document.querySelector('#wrapper #content .contentMain .center .left .leftBottom .next')
    //获取ul元素和所有li元素
    const ulNode = document.querySelector('#wrapper #content .contentMain .center .left .leftBottom .picList ul')
    const liNodes = document.querySelectorAll('#wrapper #content .contentMain .center .left .leftBottom .picList ul li')
    let start = 0;  //起点
    //每次图片走过的路程是两个li的宽度以及右侧20px的间距和
    let step = (liNodes[0].offsetWidth + 20) * 2  //步长
    //ul所可以移动的总距离 = ul的宽度 - div框的宽度 = (图片总数-图片显示数)* (li的宽度 + 20)
    let end = (liNodes.length - 5) * (liNodes[0].offsetWidth + 20)

    prev.onclick = function () {
        start -= step;
        if (start < 0) {
            start = 0
        }
        ulNode.style.left = -start + 'px' }
    next.onclick = function () {
        start += step;
        if (start > end) {
            start = end
        }
        ulNode.style.left = -start + 'px'
    }
}
```

记得给ul开启绝对定位

## 14.右侧商品上半部分详情介绍布局

### 实现

index.html

```html
<!-- 右侧详情区 -->
<div class="right">
<!-- 商品详情数据 -->
<div class="rightTop">
    <h3>Apple iPhone 6s（A1700）64G玫瑰金色 移动通信电信4G手机bbb123</h3>
    <p>推荐选择下方[移动优惠购],手机套餐齐搞定,不用换号,每月还有花费返</p>
    <div class="priceWrap">
        <div class="priceTop">
            <span>价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格</span>
            <div class="price">
                <span>￥</span>
                <p>5299</p>
                <i>降价通知</i>
            </div>
            <p>
                <span>累计评价</span>
                <span>670000</span>
            </p>
        </div>
        <div class="priceBottom">
            <span>促&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;销</span>
            <p>
                <span>加价购</span>
                <span>满999.00另加20.00元，或满1999.00另加30.00元，或满2999.00另加40.00元，即可在购物车换购热销商品</span>
            </p>
        </div>
    </div>
    <div class="support">
        <span>支&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;持</span>
        <p>以旧换新，闲置手机回收 4G套餐超值抢 礼品购</p>
    </div>
    <div class="address">
        <span>配&nbsp;送&nbsp;至</span>
        <p>广东省 深圳市 宝安区</p>
    </div>
</div>
<!-- 商品详情数据结束 -->
</div>
<!-- 右侧详情区结束 -->
```

index.less

```less
//右侧详情区
.right {
    width: 700px;
    float: right;
    //右上
    .rightTop {
        h3 {
            font-size: 14px;
            line-height: 21px;
            margin-top: 15px;
        }
        >p {
            color: #e12228;
            margin-top: 15px;
        }
        //价格区
        .priceWrap {
            margin-top: 10px;
            line-height: 28px;
            background: #fee9ec;
            padding: 7px;
            .priceTop {
                .clearfix();
                >span {
                    float: left;
                    margin-right: 15px;
                }
                .price {
                    float: left;
                    color: #cc1122;
                    span {
                        float: left;
                        font-size: 16px;
                    }
                    p {
                        float: left;
                        font-size: 24px;
                        font-weight: bold;
                    }
                    i {
                        float: left;
                        font-size: 12px;
                    }
                }
                p {
                    float: right;
                }
            }
            .priceBottom {
                .clearfix();
                >span {
                    float: left;
                    margin-right: 15px;
                }
                p {
                    float: left;
                    width: 520px;
                    line-height: 28px;

                    span {
                        color: #999;
                            &:first-child
                            {
                                background: #c81623;
                                color: #fff;
                                padding: 3px;
                            }
                    }
                }
            }
        }
        //价格区结束
        .support {
            margin-top: 10px;
            line-height: 28px;
            .clearfix();                
            span {
                float: left;
                margin-right: 15px;
            }
            p {
                float: left;
                width: 520px;
                color: #999;
            }
        }
        .address {
            margin-top: 10px;
            line-height: 28px;
            border-bottom: 1px solid #ededed;
            padding-bottom: 5px;
            .clearfix();
            span {
                float: left;
                margin-right: 15px;
            }
            p {
                float: left;
                width: 520px;
                color: #999;
            }
        }
    }
    //右上结束
}
//右侧详情区结束
```

### 此部分收获

当一个盒子中出现多个相同的元素，使用`>`指定为亲儿子元素是非常有必要的

## 15.右侧商品上半部分详情介绍数据动态渲染

### 实现

```js
rightTopData()
//商品详情数据动态渲染
function rightTopData() {
    //获取商品详情页面元素
    const rightTop = document.querySelector('#content > div > div.center > div.right > div')
    const goodsDetail = goodData.goodsDetail
    //使用模板字符串
    var s = `
        <h3>${goodsDetail.title}</h3>
        <p>${goodsDetail.recommend}</p>
        <div class="priceWrap">
         <div class="priceTop">
         <span>价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格</span>
         <div class="price">
          <span>￥</span>
          <p>${goodsDetail.price}</p>
          <i>降价通知</i>
         </div>
        <p>
         <span>累计评价</span>
         <span>${goodsDetail.evaluateNum}</span>
        </p>
        </div>

        <div class="priceBottom">
         <span>促&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;销</span>
        <p>
         <span>${goodsDetail.promoteSales.type}</span>
         <span>${goodsDetail.promoteSales.content}</span>
        </p>
        </div>

        </div>
        <div class="support">
         <span>支&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;持</span>
         <p>${goodsDetail.support}</p>
        </div>

        <div class="address">
         <span>配&nbsp;送&nbsp;至</span>
         <p>${goodsDetail.address}</p>
        </div>
        `
    rightTop.innerHTML = s;
}
```

### 此部分收获

复习了模板字符串的使用

## 16.右侧商品下半部分商品参数布局

### 实现

index.html

```html
<!-- 商品参数 -->
<div class="rightBottom">
    <!--选择区域的列表-->
    <div class="chooseWrap">
        <dl>
            <dt>选择颜色</dt>
            <dd>金色</dd>
            <dd>银色</dd>
            <dd>黑色</dd>
        </dl>
        <dl>
            <dt>内存容量</dt>
            <dd>16G</dd>
            <dd>64G</dd>
            <dd>128G</dd>
            <dd>256G</dd>
        </dl>
        <dl>
            <dt>选择版本</dt>
            <dd>公开版</dd>
            <dd>移动版</dd>
        </dl>
        <dl>
            <dt>购买方式</dt>
            <dd>官方标配</dd>
            <dd>优惠移动版</dd>
            <dd>电信优惠版</dd>
        </dl>
    </div>
    <!--选择区域的列表结束-->
</div>
<!-- 商品参数结束 -->
```

index.less

```less
//右下
.rightBottom {
    margin-top: 10px;
    line-height: 28px;

    //选择区域的列表
    .chooseWrap {
        dl {
            margin-top: 13px;
            margin-bottom: 13px;
            .clearfix();

            dt {
                float: left;
                margin-right: 15px;
            }

            dd {
                float: left;
                margin-right: 5px;
                color: #666;
                line-height: 24px;
                padding: 2px 14px;
                border-top: 1px solid #eee;
                border-left: 1px solid #eee;
                border-right: 1px solid #bbb;
                border-bottom: 1px solid #bbb;

                &:first-of-type {
                    color: red;
                }
            }
        }
    }
}
//右下结束
```

## 17.右侧商品下半部分商品参数数据动态渲染

### 实现

```js
rightBottomData()
//商品参数数据动态渲染
function rightBottomData() {
    // 查找元素对象
    const chooseWrap = document.querySelector('#wrapper #content .contentMain .center .right .rightBottom .chooseWrap')
    //获取数据
    const crumbData = goodData.goodsDetail.crumbData;

    //遍历数组
    for (let i = 0; i < crumbData.length; i++) {
        let dlNode = document.createElement('dl');
        let dtNode = document.createElement('dt');
        //设置dt的值为数组中的title的值
        dtNode.innerHTML = crumbData[i].title;
        //追加dt元素
        dlNode.appendChild(dtNode);
        //循环crumbData里面每一个元素下的data
        for (let j = 0; j < crumbData[i].data.length; j++) {
            let ddNode = document.createElement('dd');
            //设置dd的值为数组中type的值
            ddNode.innerHTML = crumbData[i].data[j].type;
            //让dl追加dd元素
            dlNode.appendChild(ddNode);
        }
        //让chooseWrap循环追加dl元素
        chooseWrap.appendChild(dlNode);
    }
}
```

## 18.点击每行参数的文字颜色排他效果

### 实现

```js
clickDDbind();
//点击每行参数的文字颜色排他效果
function clickDDbind() {
    //获取所有的dl元素
    const dlNodes = document.querySelectorAll('#wrapper #content .contentMain .center .right .rightBottom .chooseWrap dl');
    for (let i = 0; i < dlNodes.length; i++) {
        //获取第一个dl中的所有的dd元素
        let ddNodes = dlNodes[i].querySelectorAll('dd');
        //循环添加点击事件
        for (let j = 0; j < ddNodes.length; j++) {
            ddNodes[j].onclick = function () {
                //排他思想：
                //(1) 其他dd保持不动
                for (let k = 0; k < ddNodes.length; k++) {
                    ddNodes[k].style.color = '#666'
                }
                //(2) 点击dd变色
                this.style.color = 'red';
            }
        }
    }
}
```

这里后一节老师讲了关于var关键字的闭包问题，我没有听

## 19.选择结果的布局

### 实现

index.html

```html
<!--被选择的区域-->
<div class="choosed">
    <div class="mark">金色<a>X</a></div>
    <div class="mark">128G<a>X</a></div>
    <div class="mark">移动版<a>X</a></div>
    <div class="mark">优惠移动版<a>X</a></div>
</div>
```

index.less

```less
.choosed{
    .clearfix();
    .mark 
    {
        float: left;
        height: 30px;
        background: snow;
        border: 1px solid #ddd;
        padding: 0 20px;
        margin-right: 20px;                       
        a 
        {
            color: red;
            margin-left: 20px;
        }
    }
}
```

## 20.点击商品参数实现对应结果的动态添加

### 实现

index.js

```js
choose.innerHTML = '';
arr[i] = this.innerText
arr.forEach(function(value){
    if(value){
        let markDiv = document.createElement('div')
        markDiv.className = 'mark'
        markDiv.innerText = value
        let aNode = document.createElement('a')
        aNode.innerText = 'X'
        markDiv.appendChild(aNode)
        choose.appendChild(markDiv)
    }
})
```

### 不足

应该添加初始值

## 21.点击删除按钮实现删除对应参数数据

我这里和老师讲的不一样，其实没有老师讲的那么麻烦，只需要在创建删除按钮的同时给他绑定点击事件即可，三行搞定

```js
aNode.onclick = function(){
    ddNodes[j].style.color = '#666'
    ddNodes[0].style.color = 'red'
    choose.removeChild(markDiv)
}
```

## 22.价格变动的实现

这里我还是和老师不一样，也是更加简单，主要思路为在每次点击参数后，重新计算总价格；每次点击删除后，重新计算总价格

```js
//点击每行参数的效果
function clickDDbind() {
    //获取所有的dl元素
    const dlNodes = document.querySelectorAll('#wrapper #content .contentMain .center .right .rightBottom .chooseWrap dl');
    //获取选择元素
    const choose = document.querySelector('#wrapper #content .contentMain .center .right .rightBottom .choosed')
    const arr = new Array(dlNodes.length);
    //获取总价元素
    const price = document.querySelector('#wrapper #content .contentMain .center .right .rightTop .priceWrap .priceTop .price p')
    //获取数据里的总价
    let count = goodData.goodsDetail.price
    //初始化总价
    price.innerText = count
    
    for (let i = 0; i < dlNodes.length; i++) {
        //获取当前dl中的所有的dd元素
        let ddNodes = dlNodes[i].querySelectorAll('dd');

        for (let j = 0; j < ddNodes.length; j++) {       
            //循环添加点击事件       
            ddNodes[j].onclick = function () {
                //其他dd保持#666颜色
                for (let k = 0; k < ddNodes.length; k++) {
                    ddNodes[k].style.color = '#666'
                }
                //当前元素变色
                this.style.color = 'red';

                choose.innerHTML = '';
                arr[i] = this.innerText
				//初始化总价
    			price.innerText = count

                arr.forEach(function(value){
                    if(value){
                        // 每次重新渲染都重新计算价格
                        count+=goodData.goodsDetail.crumbData[i].data[j].changePrice
                        price.innerText = count

                        let markDiv = document.createElement('div')
                        markDiv.className = 'mark'
                        markDiv.innerText = value
                        let aNode = document.createElement('a')
                        aNode.innerText = 'X'
                        markDiv.appendChild(aNode)
                        choose.appendChild(markDiv)
                        
                        aNode.onclick = function(){    
                            // 每次点击删除都重新计算价格                            
                            count-=goodData.goodsDetail.crumbData[i].data[j].changePrice
                            price.innerText = count
                            //删除后当前参数恢复初始颜色
                            ddNodes[j].style.color = '#666'
                            //第一个为红色
                            ddNodes[0].style.color = 'red'
                            //移出
                            choose.removeChild(markDiv)                               
                        }
                    }

                })
            }
        }
    }

}
```

## 23.购物车以及购买价格布局

index.html

```html
<!--加入购物车-->
<div class="addcart">
    <div class="count">
        <input type="text">
        <a href="javascript:;">+</a>
        <a href="javascript:;">-</a>
    </div>
    <button>加入购物车</button>
</div>
```

index.css

```less
//加入购物车
    .addcart 
    {
        .clearfix();

        .count 
        {
            float: left;
            width: 55px;
            margin-right: 15px;
            position: relative;

            input 
            {
                width: 38px;
                height: 37px;
                border: 1px solid #ddd;
                color: #555;
            }

            a 
            {
                width: 15px;
                height: 18px;
                line-height: 18px;
                text-align: center;
                border: 1px solid #ddd;
                background: #f1f1f1;
                color: #666;
                position: absolute;
                right: 1px;

                &:first-child {
                    top: 0;
                }

                &:last-child {
                    top: 20px;
                    border-top: none;
                }
            }
        }

        button {
            float: left;
            padding: 0 25px;
            height: 36px;
            font-size: 16px;
            background: #e1251b;
            color: #fff;
            border: none;
        }
    }
}
//加入购物车结束
```

## 24.中间左侧选项卡整体结构布局

index.html

```html
<!-- 商品详情中间部分 -->
<div class="goodsDetailWrap">
    <!--左边侧边栏-->
    <aside class="leftAside">
        <!--上部点击按钮区域-->
        <div class="asideTop">
            <h4 class="active">相关分类</h4>
            <h4>推荐品牌</h4>
        </div>
    </aside>
</div>             
<!-- 商品详情中间部分结束 -->
```

index.less

```less
//左边侧边栏
.leftAside {
    float: left;
    width: 210px;
    border: 1px solid #ccc;

    //上部点击按钮区域
    .asideTop {
        height: 40px;

        h4 {
            float: left;
            width: 50%;
            height: 37px;
            line-height: 37px;
            text-align: center;
            border-top: 3px solid #fff;
            border-bottom: 1px solid #ccc;

            &.active {
                border-top: 3px solid #e1251b;
                border-bottom: 1px solid #fff;
            }
        }
    }
}
//左边侧边栏结束
```

## 25.中间左侧选项卡中具体内容布局搭建

index.html

```html
<!-- 下面 -->
<div class="aslideContent">
    <div class="active">
        <!-- 列表 -->
        <ul class="goodsList1">
            <li>手机</li>
            <li>手机壳</li>
            <li>内存卡</li>
            <li>iphone配件</li>
            <li>贴膜</li>
            <li>手机耳机</li>
            <li>移动电源</li>
            <li>平板电脑</li>
        </ul>
        <ul class="goodsList2">
            <li>
                <img src="images/part01.png" alt="">
                <span>Apple苹果iPhone 6s (A1699)</span>
                <p>¥6088.00</p>
                <div class="button">
                    <a href="javascript:;">加入购物车</a>
                </div>
            </li>
            <li>
                <img src="images/part01.png" alt="">
                <span>Apple苹果iPhone 6s (A1699)</span>
                <p>¥6088.00</p>
                <div class="button">
                    <a href="javascript:;">加入购物车</a>
                </div>
            </li>
            <li>
                <img src="images/part01.png" alt="">
                <span>Apple苹果iPhone 6s (A1699)</span>
                <p>¥6088.00</p>
                <div class="button">
                    <a href="javascript:;">加入购物车</a>
                </div>
            </li>
            <li>
                <img src="images/part01.png" alt="">
                <span>Apple苹果iPhone 6s (A1699)</span>
                <p>¥6088.00</p>
                <div class="button">
                    <a href="javascript:;">加入购物车</a>
                </div>
            </li>
        </ul>
    </div>
</div>
<!-- 下面结束 -->
```

index.less

```less
//下部列表区域
.aslideContent {
    padding: 10px;
    .active {
        // 列表
        .goodsList1 {
            .clearfix();
            li {
                float: left;
                width: 50%;
                line-height: 28px;
                border-bottom: 1px dashed #ededed;
            }
        }
        //图片列表
        .goodsList2 {
            li {
                margin: 5px 0 15px;
                border-bottom: 1px solid #ededed;
                img {
                    width: 152px;
                }
                p {
                    font-size: 16px;
                    color: #c81623;
                }
                .button {
                    margin-top: 5px;
                    margin-bottom: 5px;
                    text-align: center;
                    a {
                        border: 1px solid #8c8c8c;
                        color: #8c8c8c;
                        padding: 2px 14px;
                        line-height: 18px;
                    }
                }
            }
        }
        //图片列表结束
    }
}
//下部列表区域结束
```

## 26.中间右侧选择搭配的整体结构布局

index.html

```html
<!--右边区域-->
<div class="rightDetail">
    <!--选择区域-->
    <div class="chooseWrap">
        <h4>选择搭配</h4>
        <!-- 内容 -->
        <div class="listWrap">
            <div class="left">
                <img src="images/l-m01.png" alt="">
                <p>¥5299</p>
                <i>+</i>
            </div>
            <ul class="middle">
                <li>
                    <img src="images/dp01.png" alt="">
                    <span>Feless费勒斯VR</span>
                    <div>
                        <input type="checkbox" value="50">
                        <span>50</span>
                    </div>
                </li>
                <li>
                    <img src="images/dp02.png" alt="">
                    <span>Feless费勒斯VR</span>
                    <div>
                        <input type="checkbox" value="50">
                        <span>50</span>
                    </div>
                </li>
                <li>
                    <img src="images/dp03.png" alt="">
                    <span>Feless费勒斯VR</span>
                    <div>
                        <input type="checkbox" value="50">
                        <span>50</span>
                    </div>
                </li>
                <li>
                    <img src="images/dp04.png" alt="">
                    <span>Feless费勒斯VR</span>
                    <div>
                        <input type="checkbox" value="50">
                        <span>50</span>
                    </div>
                </li>
            </ul>
            <div class="right">
                <div>已购0件商品</div>
                <p>套餐价</p>
                <i>¥5299</i>
                <div>
                    <button>加入购物车</button>
                </div>
            </div>
        </div>
        <!-- 内容结束 -->
    </div>
    <!--选择区域结束-->
</div>
<!--右边区域结束-->
```

index.less

```less
//右侧结构
.rightDetail {
    float: right;
    width: 980px;
    //选择区域
    .chooseWrap {
        border: 1px solid #ddd;
        margin-bottom: 15px;

        h4 {
            border-bottom: 1px solid #ddd;
            background: #f1f1f1;
            color: #333;
            padding: 5px 0 5px 15px;
        }
        .listWrap {
            height: 170px;
            padding-top: 10px;

            .left {
                float: left;
                width: 127px;
                height: 165px;
                position: relative;

                img {
                    width: 87px;
                    margin: 0 auto;
                }

                p {
                    color: #c81623;
                    font-size: 16px;
                    text-align: center;
                }

                i {
                    font-size: 16px;
                    position: absolute;
                    top: 48px;
                    right: -25px;
                }
            }
            .middle {
                float: left;
                width: 668px;
                height: 165px;

                li {
                    float: left;
                    width: 127px;
                    margin: 0 20px;
                    text-align: center;

                    img {
                        width: 120px;
                        height: 130px;
                    }
                }
            }
            .right {
                float: left;
                border-left: 1px solid #ddd;
                width: 153px;
                height: 165px;
                padding-left: 20px;

                >div {
                    margin-top: 10px;
                    margin-bottom: 10px;
                }

                >p {
                    font-weight: bold;
                    margin-bottom: 10px;
                }

                >i {
                    font-size: 16px;
                    color: #B1191A;
                    margin-bottom: 10px;
                }
                button {
                    padding: 10px 25px;
                    font-size: 16px;
                    color: #fff;
                    background: #e1251b;
                    border: none;
                }
            }
        }
    }
}    
//右侧结构结束
```

## 27.选择搭配中复选框选中状态的套餐价联动效果

这里还是和老师不一样

```js
function setLeftPrice(price) {
    const leftPrice = document.querySelector('#wrapper #content .contentMain .goodsDetailWrap .rightDetail .chooseWrap .listWrap .left p')
    leftPrice.innerText = '￥' + price;
    setRightPrice(leftPrice.innerText)
}
function setRightPrice(price) {
    const inputs = document.querySelectorAll('#wrapper #content .contentMain .goodsDetailWrap .rightDetail .chooseWrap .listWrap .middle li div input')
    const rightPrice = document.querySelector('#wrapper #content .contentMain .goodsDetailWrap .rightDetail .chooseWrap .listWrap .right > i')

    console.log(price)
    price = price == undefined ? 0 : Number(price.slice(1))

    for (let i = 0; i < inputs.length; i++) {
        if (inputs[i].checked) {
            price = price + Number(inputs[i].value);
            console.log(price)
        }
    }
    rightPrice.innerText = '￥' + price;
}
choosePrice()
// 选择搭配中复选框选中状态的套餐价联动效果
function choosePrice() {
    //获取复选框元素
    const inputs = document.querySelectorAll('#wrapper #content .contentMain .goodsDetailWrap .rightDetail .chooseWrap .listWrap .middle li div input')
    const leftPrice = document.querySelector('#wrapper #content .contentMain .goodsDetailWrap .rightDetail .chooseWrap .listWrap .left p')
    const rightPrice = document.querySelector('#wrapper #content .contentMain .goodsDetailWrap .rightDetail .chooseWrap .listWrap .right > i')
    rightPrice.innerHTML = leftPrice.innerText
    console.log(leftPrice)
    for (let i = 0; i < inputs.length; i++) {
        inputs[i].onclick = function () {
            setRightPrice(leftPrice.innerText)
        }
    }

}
```

后面看了都是页面布局的问题了，那么就做到这里吧。

# 总结

css页面布局没什么可讲的了，最多用element-ui代替，但是做不出个性化定制，但是原生js，还是用Vue香啊省去多少事啊