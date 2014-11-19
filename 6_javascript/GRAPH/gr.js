var equation =  x.split("x+");
   document.getElementById("Equation").innerHTML = equation;
    var m=parseInt(equation[0]);    
    var c=parseInt(equation[1]);
  
    var result=parseInt(m*getInbound+c);
    alert(result);


   
   var in_bound=parseInt(getInbound);
   //alert(us);
  var enter_step=parseInt(getStep);
   //alert(we);
  var res=parseInt(in_bound+enter_step);
  //alert(sum);
   var output=parseInt(m*res+c);
   alert(output);
   
  ctx.translate(200,200);
  ctx.moveTo(getInbound,result);
  ctx.lineTo(res,-output);
  ctx.stroke();
   
  
var getInbound=document.getElementById("getInbound");
var OutInbound=document.getElementById("getOutbound");
for (i=getInbound,i<OutInbound,i+step)
{
var y=mx+c;

}
}
