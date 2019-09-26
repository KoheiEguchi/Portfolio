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
