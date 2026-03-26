
const chatPage = document.querySelector("#chat-page");
const msgCardBody = document.querySelector(".msg_card_body");
const sendBtn = document.querySelector(".send_btn");
const messageInput = document.querySelector(".type_msg");

const stompClient = Stomp.over(new SockJS("/ws"));



stompClient.connect({}, function (frame) {
  console.log("Connected to WebSocket server.", frame);

  // Subscribe to the public topic
  stompClient.subscribe("/topic/public", function (message) {
   // showMessage(JSON.parse(message.body));
    console.log("Received message:", message.body);
    console.log("Received message:", message);
  });
}, function (error) {
  console.error("Error connecting to WebSocket server:", error);
});
sendBtn.addEventListener("click", function () {
const messageContent = sendMessage();
saveMessageToDatabase(messageContent);
 getMessagesBetweenUsers('malak','hanaa');

});

messageInput.addEventListener("keydown", function (event) {
  if (event.key === "Enter") {
    event.preventDefault();
 
    const messageContent = sendMessage();
saveMessageToDatabase(messageContent);
   
  }
});

function saveMessageToDatabase(messageContent) {
  // Get the message, sender id and receiver id
  const senderId = 'hanaa';
  const receiverId = 'malak';

// Get the current date and time
const currentDate = new Date();

// Get the date components
const year = currentDate.getFullYear();
const month = String(currentDate.getMonth() + 1).padStart(2, '0'); // Note: getMonth() returns zero-based month
const day = String(currentDate.getDate()).padStart(2, '0');

// Get the time components
const hours = String(currentDate.getHours()).padStart(2, '0');
const minutes = String(currentDate.getMinutes()).padStart(2, '0');
const seconds = String(currentDate.getSeconds()).padStart(2, '0');

// Combine date and time in the desired format
const formattedDateTime = `${year}-${month}-${day} ${hours}:${minutes}:${seconds}`;
  const MessageRequest = {
    message: messageContent,
    senderId: senderId,
    receiverId: receiverId,
    timestamp:formattedDateTime,
  };

  console.log(MessageRequest);

  // Use fetch API to send a POST request to your Spring Boot backend
  fetch('/messages', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(MessageRequest),
  })
  .then(response => response.json())
  .then(data => {
    console.log('Success:', data);
  })
  .catch((error) => {
    console.error('Error:', error);
  });
}



function sendMessage() {
  const messageContent = messageInput.value.trim();
  if (messageContent) {
    const chatMessage = {
      content: messageContent,
    };
    stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
    showMessage(messageContent);
    messageInput.value = "";
    return messageContent; 
  }
}

function showMessage(messageContent) {
	const msgContainer = document.createElement("div");
	msgContainer.classList.add("d-flex", "justify-content-start", "mb-4");

	const msgContent = document.createElement("div");
	msgContent.classList.add("msg_cotainer_send");
	msgContent.textContent =messageContent;

	const msgTime = document.createElement("span");
	msgTime.classList.add("msg_time");
	//msgTime.textContent = formatDate(new Date(message.formatDate));
	//msgTime.textContent = formatDate(new Date(message.timestamp));
	msgContent.appendChild(msgTime);
	msgContainer.appendChild(msgContent);

	msgCardBody.appendChild(msgContainer);
	msgCardBody.scrollTop = msgCardBody.scrollHeight;
}


function showMessage2(messageContent) {
	const msgContainer = document.createElement("div");
	msgContainer.classList.add("d-flex", "justify-content-start", "mb-4");

	const msgContent = document.createElement("div");
	msgContent.classList.add("msg_cotainer");
	msgContent.textContent =messageContent;

	const msgTime = document.createElement("span");
	msgTime.classList.add("msg_time");
	//msgTime.textContent = formatDate(new Date(message.formatDate));
	//msgTime.textContent = formatDate(new Date(message.timestamp));
	msgContent.appendChild(msgTime);
	msgContainer.appendChild(msgContent);

	msgCardBody.appendChild(msgContainer);
	msgCardBody.scrollTop = msgCardBody.scrollHeight;
}

function formatDate(date) {
	const hours = date.getHours().toString().padStart(2, "0");
	const minutes = date.getMinutes().toString().padStart(2, "0");
	const ampm = hours >= 12 ? "PM" : "AM";

	return `${hours}:${minutes} ${ampm}, Today`;
}




// إرسال طلب GET لجلب الرسائل بين المستخدمين
function getMessagesBetweenUsers(user1, user2) {
  // إرسال طلب GET لجلب الرسائل بين المستخدمين
  fetch(`/messages/${user1}/${user2}`)
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      return response.json(); // تحويل البيانات إلى JSON
    })
    .then(data => {
      // القيام بأي شيء تريده مع البيانات المسترجعة
      console.log(data); // عرض البيانات في وحدة التحكم كمثال
      displayMessages(data); // عرض البيانات في واجهة المستخدم
    })
    .catch(error => {
      console.error('There was a problem with your fetch operation:', error);
    });
}

// عند الضغط على زر محدد مثلاً

function displayMessages(messages) {
	//console.log(messages);
    // حلق عبر قائمة الرسائل وعرض كل رسالة في واجهة المستخدم
   
     for (let i = 0; i < messages.length; i++) {
       if (messages[i].expediteur.email === 'hanaa') {
            console.log(messages[i].expediteur.email);
            showMessage(messages[i].contenu);
        }
         if (messages[i].expediteur.email === 'malak') {
            console.log(messages[i].expediteur.email);
            showMessage2(messages[i].contenu);
        }
    }
}
