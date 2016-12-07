function add(){
    console.log('add');
    var selectArray=$('#person_select').val();
    var selectResult=$('#person_result');
    console.log(selectArray);
    for(x in selectArray){
        var text=selectArray[x];
        //暂不查重
        selectResult.append("<option value='"+text+"'>"+text+"</option>");
    }
}
function remove(){
    var obj=document.getElementById('person_result');
    //index,要删除选项的序号，这里取当前选中选项的序号
    var index=obj.selectedIndex;
    obj.options.remove(index);
}