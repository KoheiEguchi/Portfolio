var slideshowNum = 0;

//画像クリックで切り替え
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