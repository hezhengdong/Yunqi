function fopen(evt, tabName) {
    var tabcontent = document.getElementsByClassName("tabcontent");
    for (var i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
     }
        // 获取所有选项卡按钮，并移除它们的激活状态
    var tablinks = document.querySelectorAll(".verticalTab");
    for (var i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
        // 显示指定的选项卡内容，并将按钮标记为激活状态
    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
}
function openup(e,mainTabName){
    var mainTabContent=document.getElementsByClassName("mainTabContent")
    for(var j=0;j<mainTabContent.length;j++){
        mainTabContent[j].style.display="none"
    }
    var mainTablinks=document.querySelectorAll(".horizontalTab")
    for(var j=0;j<mainTablinks.length;j++){
        mainTablinks[j].className=mainTablinks[j].className.replace(" active","");
    }
    document.getElementById(mainTabName).style.display="flex";
    e.currentTarget.className+=" active";
}
    
    //将主选择卡背景颜色变成透明
function change2() {
    var head =document.getElementById('head')
    head.style.backgroundColor = 'rgba(0, 0, 0, 0)';
    head.style.position='absolute'
    head.style.zIndex = '8'
    document.getElementById("page2-bj").style.transform='translate(0,-90px)';
}
    //将背景颜色变成深橙色
function change3() {
    var head = document.getElementById('head')
    head.style.backgroundColor = '#ff9901';
    head.style.zIndex = 'none'
    head.style.position = 'static'
}
function change4() {
    var head = document.getElementById('head')
    head.style.backgroundColor = 'rgb(252, 202, 80)';
    head.style.zIndex = 'none'
    head.style.position = 'static'
    
}