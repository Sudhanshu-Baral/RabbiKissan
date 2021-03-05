package com.example.rabbikissan;
//import java.util.Date;

public class ChatData {



        private String messageText;
        private String messageUser;
       private String Key;
       // private long messageTime;

        public ChatData(){

        }

        public ChatData(String messageText, String messageUser) {
            this.messageText = messageText;
            this.messageUser = messageUser;
            //messageTime = new Date().getTime();
           this.Key = Key;
        }


        public String getKey() {
           return Key;
      }

       public void  setKey(String Key) {
           this.Key=Key;
        }

        public String getMessageText() {
            return messageText;
        }

        public void setMessageText(String messageText) {
            this.messageText = messageText;
        }

        public String getMessageUser() {
            return messageUser;
        }

        public void setMessageUser(String messageUser) {
            this.messageUser = messageUser;
        }

       // public long getMessageTime() {
         //   return messageTime;
        //}

        //public void setMessageTime(long messageTime) {
            //this.messageTime = messageTime;
       // }

    @Override
    public String toString() {
        return "ChatData{" +
                "messageText='" + messageText + '\'' +
                ", messageUser='" + messageUser + '\'' +
                ", Key='" + Key + '\'' +
                '}';
    }
}


