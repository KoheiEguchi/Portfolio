//画像クリックで切り替え
var slideshowNum = 0;
function slideshow(id){
	var officeSystemImgs = new Array("img/officeSystemIndex.jpg", "img/officeSystemWorkTimeCheck.jpg");
	var muMeisyoImgs = new Array("img/muMeisyoBrowse.jpg", "img/muMeisyoPost.jpg");
	var utanokaiImgs = new Array("img/utanokaiTop.jpg", "img/utanokaiCompose.jpg");
	
	if(slideshowNum == 1){
		slideshowNum = 0;
	}else{
		slideshowNum++;
	}
	
	switch(id){
	case "officeSystemImg":
		document.getElementById(id).src = officeSystemImgs[slideshowNum];
		break;
	case "muMeisyoImg":
		document.getElementById(id).src = muMeisyoImgs[slideshowNum];
		break;
	case "utanokaiImg":
		document.getElementById(id).src = utanokaiImgs[slideshowNum];
		break;
	}
}

//連絡後連絡欄を再表示する
function formOpen(formOpen){
	if(formOpen == true){
		document.getElementById("form").scrollIntoView(true);
	}
}

//連絡削除時に確認する
function deleteCheck(){
	if(confirm("本当に削除しますか？(戻せません！)")){
		return true;
	}else{
		alert("削除を中止しました。");
		return false;
	}
}
