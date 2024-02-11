const stompClient = new StompJs.Client({
    brokerURL: 'ws://localhost:8080/ws-stomp'
});

stompClient.onConnect = (frame) => {
    setConnected(true);
    const chatRoomId = $("#chatRoomId").val(); // Retrieve the chatRoomId from the input
    console.log('Connected: ' + frame);

    stompClient.subscribe(`/queue/chat/rooms/${chatRoomId}`, response => {
        showMessage(JSON.parse(response.body));
    });
};

stompClient.onWebSocketError = (error) => {
    console.error('Error with websocket', error);
};

stompClient.onStompError = (frame) => {
    console.error('Broker reported error: ' + frame.headers['message']);
    console.error('Additional details: ' + frame.body);
};

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    } else {
        $("#conversation").hide();
    }
    $("#messages").html("");
}

function connect() {
    stompClient.activate();
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.deactivate();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    const content = $("#content").val();
    const senderId = parseInt($("#senderId").val(), 10); // Correctly retrieve senderId value and parse it as an integer
    const chatRoomId = parseInt($("#chatRoomId").val(), 10);
    if (isNaN(senderId)) {
        alert("Sender ID must be a number.");
        return;
    }

    stompClient.publish({
        destination: `/app/chat/rooms/${chatRoomId}`,
        body: JSON.stringify({content : content, senderId: senderId}) // Ensure both name and senderId are included in the payload
    });
}

function showMessage(body) {
    $("#messages").append(`<tr><td>${body.senderId}: ${body.content}</td></tr>`);
}

$(function () {
    $("form").on('submit', (e) => e.preventDefault());
    $("#connect").click(connect);
    $("#disconnect").click(disconnect);
    $("#send").click(sendName);
});
