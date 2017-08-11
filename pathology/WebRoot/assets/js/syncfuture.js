//全局变量
var syncSocket;
var syncviewer;
var sign = null;
var master = null;
var syncState = "";
function ConnectServer(pHost, pName, pMessage, pParams, pViewer)//
{
    pHost = "ws://" + SyncImageServer;
    var readyStatus = new Array("正在连接", "已建立连接", "正在关闭连接", "已关闭连接");
    var host = pHost;
    var name = pName;
    var message = pMessage;
    syncviewer = pViewer;
    
    try //
    {
        syncSocket = new WebSocket(host);
        syncState = "connected";
    }
    catch (exception) //
    {
        syncState = "unconnected";
        //addMsg("对不起，您所使用的浏览器不支持WebSocket.");
        return;
    }
    //连接成功
    syncSocket.onopen = SocketOnOpen;
    //收到消息
    syncSocket.onmessage = function (msg) {
        //返回的数据msg.data，包含了协议中的4部分
        //alert(msg.data);
        /*
        1. 消息种类之间用英文逗号(,)隔开
        2. 最后一个参数是登录者信息，多个登录者之间用英文下的分号;隔开
        3. 每一个登录者信息是由登录号和昵称组成，登录号和昵称之间用|隔开
        */
        var arrays = msg.data.split(',');
        //alert("msg.data=" + msg.data); //MSG,0,0,Plus|-1.5
        //alert("type = " + arrays[0]);
        //if (arrays.length != 4)
        //    return;
        if (arrays[0] == "LIN")//收到用户登录消息
        {
            alert("LIN = " + msg.data);
        }
        else if (arrays[0] == "OLN")//好友在线列表
        {
            alert("OLN = " + msg.data);
        }
        else if (arrays[0] == "MSG")//消息内容
        {
            /*
            alert("syncviewer" + syncviewer);
            alert("syncviewer.viewport" + syncviewer.viewport);
            */
            if ((sign != null && sign == "1") && (master == null || master == "0")) //受控端
            {

                var m = arrays[arrays.length - 1];
                var marry = m.split('|');
                var msgtype = marry[0];

                if (msgtype == "syncimage") {
                   if (marry[1] == mCurrentSlideID) {
                        var s = Number(marry[2]);
                        var xx = Number(marry[3]);
                        var yy = Number(marry[4]);
                        syncPanTo(xx, yy);
                        syncviewer.zoomToObj(s);
                    }
                /*
                var leftx = Number(xx) - Number(container.width() / 2);
                var lefty = Number(yy) - Number(container.height() / 2);
                var centerx = Number(leftx) + Number(container.width() / 2);
                var centery = Number(lefty) + Number(container.height() / 2);
                centerx = centerx / (container.width() * syncviewer.viewport.getZoom());
                centery = centery / (container.width() * syncviewer.viewport.getZoom());
                */
                    //syncviewer.viewport.panTo(new Seadragon.Point(xx, yy))
                }

                /*
                if (msgtype == "plus")//加减号按钮
                {
                var mnn = Number(marry[1]);
                //syncviewer.viewport && (syncviewer.viewport.zoomBy(zoomby), syncviewer.viewport.applyConstraints())
                var center = marry[marry.length - 1];
                if (center.substr(0, 7) == "center#") {
                var a = center.split('#');
                syncPanTo(Number(a[1]), Number(a[2]));
                }
                syncviewer && syncviewer.zoomToObj(mnn);
                }
                else if (msgtype == "zoomto")//单击2，4，6，8，10按钮时
                {
                var mnn = Number(marry[1]);
                var center = marry[marry.length - 1];
                if (center.substr(0, 7) == "center#") {
                var a = center.split('#');
                syncPanTo(Number(a[1]), Number(a[2]));
                }
                syncviewer && syncviewer.zoomToObj(mnn);
                }
                else if (msgtype == "gohome")//单击 Home 按钮时
                {
                syncviewer.viewport && syncviewer.viewport.goHome();
                }
                else if (msgtype == "mousescroll")//鼠标滚动缩放时
                {
                var WindowHeight = document.body.clientHeight;
                var WindowWidth = document.body.clientWidth;
                var f = Number(marry[1]);
                var mnn = Number(marry[2]) * WindowWidth;
                var mtt = Number(marry[3]) * WindowHeight;
                var t = new SeadragonPoint(mnn, mtt);
                   

                var center = marry[marry.length - 1];
                if (center.substr(0, 7) == "center#") {
                var a = center.split('#');
                syncPanTo(Number(a[1]), Number(a[2]));
                }
                syncviewer.viewport && syncviewer.viewport.zoomBy(f, syncviewer.viewport.pointFromPixel(t, !0)), syncviewer.viewport.applyConstraints();
                }
                else if (msgtype == "mousedrag")//鼠标拖动
                {
                //alert("msg.data=" + msg.data);
                mMouseDrag(marry[1], marry[2]);
                var czoom = marry[marry.length - 1];
                if (czoom && czoom.substr(0, 6) == "czoom#") {
                var a = czoom.split('#');
                var mnn = Number(a[1]);
                syncviewer && syncviewer.zoomToObj(mnn);
                }
                }
                else if (msgtype == "usermove")//当用户单击导航图时
                {
                var mnn = Number(marry[1]);
                var mtt = Number(marry[2]);
                syncPanTo(mnn, mtt);
                var czoom = marry[marry.length - 1];
                if (czoom.substr(0, 6) == "czoom#") {
                var a = czoom.split('#');
                var mnn = Number(a[1]);
                syncviewer && syncviewer.zoomToObj(mnn);
                }
                }
                */
            }
        }
        else //未定义功能
        {
            //alert("未定义功能"); 
        }
    }

    //连接断开
    syncSocket.onclose = SocketOnClose;
}

function SocketOnOpen()//Socket onopen 事件
{

    

    //syncSocket.send("LIN,0,0," + name);
}

function SocketOnClose(event)//Socket onclose 事件
{
    //readyStatus[socket.readyState];
}

function mMouseDrag(pos, ispan) //鼠标拖动事件 harry
{
    //alert(pos);
    //MSG, 0, 0, mousedrag | (0.5126394002888518, 0.5525320072817778) | true
    var arrPos = pos.split(';');
    //var cc = new SeadragonPoint(arrPos[0], arrPos[1]);
    i = syncviewer.viewport;
    if (i) if (ispan) //
    {
        var cc = new SeadragonPoint(Number(arrPos[0]), Number(arrPos[1]));
        i.panTo(cc), i.applyConstraints();
    }
    else
        i.panBy(cc)
   
}

//=====================================================================================================================================================================
// function syncPanTo ()//
//=====================================================================================================================================================================
function syncPanTo(x,y)//发送要同步的信息
{
    var mpoint = new SeadragonPoint(x, y);
    syncviewer.viewport && syncviewer.viewport.panTo(mpoint);
}

//=====================================================================================================================================================================
// function SendSyncInfo ()//
//=====================================================================================================================================================================
function DisconnectSync()//断开socket连接
{
    syncSocket.close();
}



//=====================================================================================================================================================================
// function SendMsg ()//
//=====================================================================================================================================================================
function SendMsg(msg) //发送消息
{
    var text = msg;
    if (text == "") {
        alert("发送的消息不能为空.");
        return;
    }
    try {
        var mmsg = "MSG,0,0," + text;
        syncSocket.send(mmsg);
        //socket.send("LIN,0,0," + name);
        //socket.send("MSG," + myid + "," + document.getElementById("selMsgTo").value + "," + text);
        //addMsg("我对 " + getName(onMem) + " 说:&nbsp;&nbsp;" + text);
        //alert("来自脚本的提示：消息【" + mmsg + "】已发送");
    }
    catch (exception) {
        
    }
}
                                                                                                                  