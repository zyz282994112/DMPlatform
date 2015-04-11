
function filecheck(){
        var file = document.getElementById("exampleInputFile").value;
        if(file == ""){
          alert("�ļ�����Ϊ�գ�");
          return false;
         }else{
          return true;
         }
}

function p_del() { 
	var msg = "are you sure deleted?"; 
	if (confirm(msg)==true){ 
	return true; 
	}else{ 
	return false; 
}} 

function validate_required(field,alerttxt)
{
with (field)
  {
  if (value==null||value=="")
    {alert(alerttxt);return false}
  else {return true}
  }
}

function adjustInput11(alName) {

	var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", SHOW_A_PARAMS_URL + "?alName=" + alName.trim(), false);
    xmlhttp.send(null);
    var s = xmlhttp.responseText.toString().split(",");
    var replace = document.getElementById("replace");
    remove(replace);
    var content = "<div id='replace'>";
    var tmp ="";

    for (var i = 0; i < s.length; i++) {

        tmp = "<br/><label for=\"" + s[i].trim() + "\">" + s[i].trim() + "</label><br/>";
        content += tmp;
        tmp = "<input id =\"option\" class=\"form-control\" type=\"text\" name=\""+s[i].trim()+"\"/>";
        content += tmp;
    }
    content += '</div>';
    $("#parent").append(content);
}

$(function() {
// 任何需要执行的js特效
    var tmp = $(window).height() - $("#topheader").height()- 135;
    $(".container").css("min-height", tmp);
});





