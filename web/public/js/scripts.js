// The javascripts used in cloud computing platform
// Author: Shiwei Wu, Date: 2013-6-23

// constant variables.


//var isReload = true;
var SHOW_ALGORITHM_URL = "showAlgorithm.do";
var SHOW_A_DES_INFO_URL = "showAlgoDesInfo.do";
var SHOW_A_PARAMS_URL = "showParams.do";
var SHOW_FIM_URL = "showfim.do";
var SHOW_RULE_URL = "showrule.do";

function showAlogrithm() {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", SHOW_ALGORITHM_URL, false);
    xmlhttp.send(null);
    var alNames = xmlhttp.responseText.toString().split(" ");
    var select = document.getElementById("Algorithm_Name");

    for (var i = 0; i < alNames.length; i++) {
        var item = new Option(alNames[i].trim(), alNames[i].trim());
        select.options.add(item);
    }
}

function showADesInfo(alValue) {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", SHOW_A_DES_INFO_URL + "?alName=" + alValue, false);
    xmlhttp.send(null);
    var alDesInfo = xmlhttp.responseText.toString();
    document.getElementById("Algorithm_Description").value = alDesInfo;
//    document.getElementById("Algorithm_Info").value = alDesInfo[1];
}


function showADesInfoForQuery(alValue) {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", SHOW_A_DES_INFO_URL + "?alName=" + alValue.trim(), false);
    xmlhttp.send(null);
    var alDesInfo = xmlhttp.responseText.toString();
    document.getElementById("Description").value = "Description is:\n" + alDesInfo + "\n";
}


function remove(obj) {
    $(obj).remove();
}
function parse(str) {
    var args = [].slice.call(arguments, 1),
        i = 0;

    return str.replace(/%s/g, function () {
        return args[i++];
    });
}

function adjustInput(alValue) {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", SHOW_A_PARAMS_URL + "?alName=" + alValue.trim(), false);
    xmlhttp.send(null);
    var alParams = xmlhttp.responseText.toString().split(",");
    var replace = document.getElementById("replace");
    remove(replace);
    var content = "<div id='replace'>";

    for (var i = 0; i < alParams.length; i++) {
        content += "<br/>";
        var tmp1 = parse("<label for=\'%s\'>%s</label>", alParams[i], alParams[i]);
        content += tmp1;
        content += "<br/>";
        var tmp2 = parse("<input id=\'%s\' type=\'text\' name=\'%s\'/>", alParams[i] + "1", alParams[i]);
        content += tmp2;
        content += "<br/>";


    }
    content += '</div>';

    $("#parent").append(content);
}


function showFim() {
    var input = document.getElementById("show_file").value;
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", SHOW_FIM_URL + "?inputfile=" + input.trim(), false);
    xmlhttp.send(null);
    var img = "public/images/result/fim/" + xmlhttp.responseText.toString().trim();

    return img.toString();
}

function showRule() {
    var input = document.getElementById("show_file").value;
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", SHOW_RULE_URL + "?inputfile=" + input.trim(), false);
    xmlhttp.send(null);
    var img = "public/images/result/rule/" + xmlhttp.responseText.toString().trim();

    return img.toString();
}





