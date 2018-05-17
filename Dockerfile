FROM openjdk
COPY build/libs/slackbot-resistance-1.0-all.jar /
CMD  java -jar /slackbot-resistance-1.0-all.jar $BOT_KEY $BOT_NAME
