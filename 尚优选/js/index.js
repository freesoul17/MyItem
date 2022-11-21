//作用：需要将所有的DOM元素以及相关资源加载完毕才开始调用
window.onload = function () {
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

    bigClassBind()
    // 放大镜移入移出效果
    function bigClassBind(url) {
        //获取小图框元素
        const smallPic = document.querySelector('#wrapper #content .contentMain .center .left .leftTop .smallPic')
        //获取leftTop元素
        const leftTop = document.querySelector('#wrapper #content .contentMain .center .left .leftTop')
        //获取imagessrc数据
        const imagesSrc = goodData.imagessrc
        //设置移入事件
        smallPic.onmouseenter = function () {
            //创建蒙版元素
            let maskDiv = document.createElement('div')
            maskDiv.className = 'mask'
            //创建大图框元素
            let bigPic = document.createElement('div')
            bigPic.className = 'bigPic'
            //创建大图片元素
            let bigImg = document.createElement('img')
            bigImg.src = url == undefined ? imagesSrc[0].b : url
            //大图框追加大图片
            bigPic.appendChild(bigImg)
            //小图框追加蒙版元素
            smallPic.appendChild(maskDiv)
            //获取leftTop元素追加大图框
            leftTop.appendChild(bigPic)

            //设置鼠标移出事件
            smallPic.onmouseleave = function () {
                //移出蒙版
                smallPic.removeChild(maskDiv)
                //移出大图框
                leftTop.removeChild(bigPic)
            }

            //设置移动事件
            smallPic.onmousemove = function () {
                //左侧位置 = 鼠标距离屏幕左侧的位置 - 小图距离屏幕左侧的距离 - 蒙版宽度的一半
                let left = event.clientX - smallPic.getBoundingClientRect().left - maskDiv.offsetWidth / 2;
                //上侧位置 = 鼠标距离屏幕上侧的位置 - 小图距离屏幕上侧的距离 - 蒙版宽度的一半
                let top = event.clientY - smallPic.getBoundingClientRect().top - maskDiv.offsetHeight / 2;
                //边界控制
                if (left < 0) {
                    left = 0;
                } else if (left > smallPic.clientWidth - maskDiv.offsetWidth) {
                    left = smallPic.clientWidth - maskDiv.offsetWidth
                }
                if (top < 0) {
                    top = 0;
                } else if (top > smallPic.clientHeight - maskDiv.offsetHeight) {
                    top = smallPic.clientHeight - maskDiv.offsetHeight
                }
                maskDiv.style.left = left + 'px';
                maskDiv.style.top = top + 'px';

                //大图移动
                //移动比 = 蒙版的位置/大图的位置 = (小图的宽度-蒙版的宽度)/(大图片的宽度-大图框的宽度);
                let scale = (smallPic.clientWidth - maskDiv.offsetWidth) / (bigImg.offsetWidth - bigPic.clientWidth)
                bigImg.style.left = -left / scale + 'px';
                bigImg.style.top = -top / scale + 'px';

            }
        }

    }

    thumbnailData()
    //动态渲染放大镜缩略图的数据
    function thumbnailData() {
        // 获取picList下的ul
        const ulNodes = document.querySelector('#wrapper #content .contentMain .center .left .leftBottom .picList ul')
        //获取imagessrc数据
        const imagesSrc = goodData.imagessrc
        for (let i = 0; i < imagesSrc.length; i++) {
            //创建li元素
            let newLi = document.createElement('li')
            //创建img元素
            let newImg = document.createElement('img')
            newImg.src = imagesSrc[i].s
            //li追加img元素
            newLi.appendChild(newImg);
            //ul追加li元素
            ulNodes.appendChild(newLi)
        }
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
        //获取大图元素
        let bigImg = document.querySelector('#wrapper #content .contentMain .center .left .leftTop .bigPic img')
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
            ulNode.style.left = -start + 'px'
        }
        next.onclick = function () {
            start += step;
            if (start > end) {
                start = end
            }
            ulNode.style.left = -start + 'px'
        }
    }
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
    clickDDbind()
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
                    //获取数据里的总价
                    let count = goodData.goodsDetail.price

                    arr.forEach(function (value) {
                        if (value) {
                            // 每次重新渲染都重新计算价格
                            count += goodData.goodsDetail.crumbData[i].data[j].changePrice
                            price.innerText = count
                            setLeftPrice(count)

                            let markDiv = document.createElement('div')
                            markDiv.className = 'mark'
                            markDiv.innerText = value
                            let aNode = document.createElement('a')
                            aNode.innerText = 'X'
                            markDiv.appendChild(aNode)
                            choose.appendChild(markDiv)
                            aNode.onclick = function () {
                                // 每次点击删除都重新计算价格                            
                                count -= goodData.goodsDetail.crumbData[i].data[j].changePrice
                                price.innerText = count
                                setLeftPrice(count)

                                ddNodes[j].style.color = '#666'
                                ddNodes[0].style.color = 'red'
                                choose.removeChild(markDiv)
                            }
                        }

                    })
                }
            }
        }

    }
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
    
}