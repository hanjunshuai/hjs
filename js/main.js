//拿到页面上的元素
var pages = document.getElementsByClassName('page');
//定义变量记录当前  和 即将显示是的页面
var c = 0,
	n = 0;
//定义变量记录触摸的 结束位置
var sPos = 0,
	ePos = 0;

//保存触摸方向  true----往上翻页
var dir = true;

document.body.addEventListener('touchstart',
	function(e) {
		console.log(e.touches[0].pageY);
//		sPos = e.touches[0].pageY;
		sPos = e.touches[0].pageX;
	});
document.body.addEventListener('touchend',
	function(e) {
		isDir();
	});
document.body.addEventListener('touchmove',
	function(e) {
//		ePos = e.touches[0].pageY;
		ePos = e.touches[0].pageX;
	});

function isDir() {
	//防止误点发生
	if(Math.abs(sPos - ePos) > 30) {
		//判断触摸的方向
		sPos - ePos > 0 ? dir = true : dir = false;

		pageMove();
	}
}

function pageMove() {
	if(dir) {
		n = c + 1;
		n > pages.length - 1 ? n = 0 : 0;
		pages[c].className = 'page page' + c + ' toTop';
		pages[n].className = 'page page' + n + ' toBottom fromBottom';
		c = n;
		return;
	}
	n = c - 1;
	n < 0 ? n = pages.length - 1 : 0;
	pages[c].className = 'page page' + c + ' pageToB';
	pages[n].className = 'page page' + n + ' toBottom pageFromT';
	c = n;
}