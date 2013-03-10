$(document).ready(function(){
 $("#Home").click(function(){
  $("#contentContainer").load("WebHome.html .content");
 });
 $("#Statistika").click(function(){
  $("#contentContainer").load("WebStatistika.html .content");
 });
 $("#Valijale").click(function(){
  $("#contentContainer").load("WebValijale.html .content");
 });
 $("#Kandidaadid").click(function(){
  $("#contentContainer").load("WebKandidaadid.html .content");
 });
 $("#Logi").click(function(){
  $("#contentContainer").load("WebLogi.html .content");
 });     
});

