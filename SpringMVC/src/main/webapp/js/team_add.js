function add(){
    console.log('add');
    var selectArray=$('#person_select').val();
    var selectResult=$('#person_result');
    console.log(selectArray);
    for(x in selectArray){
        var text=selectArray[x];
        //�ݲ�����
        selectResult.append("<option value='"+text+"'>"+text+"</option>");
    }
}
function remove(){
    var obj=document.getElementById('person_result');
    //index,Ҫɾ��ѡ�����ţ�����ȡ��ǰѡ��ѡ������
    var index=obj.selectedIndex;
    obj.options.remove(index);
}