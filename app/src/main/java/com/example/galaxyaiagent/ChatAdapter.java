package com.example.galaxyaiagent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Message> messageList;

    public ChatAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    @Override
    public int getItemViewType(int position) {
        Message message = messageList.get(position);
        if (message.getType() == Message.TYPE_LOADING) {
            return Message.TYPE_LOADING;
        } else if (message.getType() == Message.TYPE_EVENT_CARD) {
            return Message.TYPE_EVENT_CARD;
        } else {
            return message.getType();
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == Message.TYPE_LOADING) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.loading_item, parent, false);
            return new LoadingViewHolder(view);
        } else if (viewType == Message.TYPE_EVENT_CARD) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.event_card_item, parent, false);
            return new EventCardViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.message_item, parent, false);
            return new MessageViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Message message = messageList.get(position);
        System.out.println("Binding view at position " + position + " with type " + message.getType());

        if (holder instanceof MessageViewHolder) {
            MessageViewHolder messageHolder = (MessageViewHolder) holder;
            if (message.getType() == Message.TYPE_USER) {
                messageHolder.userMessage.setText(message.getText());
                messageHolder.userMessage.setVisibility(View.VISIBLE);
                messageHolder.aiMessage.setVisibility(View.GONE);
            } else if (message.getType() == Message.TYPE_AI) {
                messageHolder.aiMessage.setText(message.getText());
                messageHolder.aiMessage.setVisibility(View.VISIBLE);
                messageHolder.userMessage.setVisibility(View.GONE);
            }
        } else if (holder instanceof LoadingViewHolder) {
            LoadingViewHolder loadingHolder = (LoadingViewHolder) holder;
            loadingHolder.appName.setText(MainActivity.currentAppName);
            loadingHolder.status.setText(MainActivity.currentStatus);

            // Show appropriate icon based on current app
            // Show appropriate icon based on current app
            if (MainActivity.currentAppName.equals("Samsung Calendar")) {
                loadingHolder.calendarIcon.setVisibility(View.VISIBLE);
                loadingHolder.aiThinkIcon.setVisibility(View.GONE);
                loadingHolder.skullText.setVisibility(View.GONE);
            } else if (MainActivity.currentAppName.equals("Kernel Exploit")) {
                loadingHolder.skullText.setVisibility(View.VISIBLE);
                loadingHolder.calendarIcon.setVisibility(View.GONE);
                loadingHolder.aiThinkIcon.setVisibility(View.GONE);
            } else {
                loadingHolder.aiThinkIcon.setVisibility(View.VISIBLE);
                loadingHolder.calendarIcon.setVisibility(View.GONE);
                loadingHolder.skullText.setVisibility(View.GONE);
            }
        } else if (holder instanceof EventCardViewHolder) {
            System.out.println("Binding event card view holder");
            EventCardViewHolder cardHolder = (EventCardViewHolder) holder;
            String[] parts = message.getText().split("\\|");
            if (parts.length >= 4) {
                cardHolder.eventTitle.setText(parts[0]);
                cardHolder.eventTime.setText(parts[1]);
                cardHolder.eventDate.setText(parts[2]);
                cardHolder.eventLocation.setText(parts[3]);

                // Set click listener on the card container
                cardHolder.eventCardContainer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println("Event card clicked!");
                        String eventInfo = parts[0] + " at " + parts[1] + " (" + parts[2] + ")";
                        Toast.makeText(v.getContext(), "Event tapped: " + eventInfo, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public static class MessageViewHolder extends RecyclerView.ViewHolder {
        TextView userMessage;
        TextView aiMessage;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            userMessage = itemView.findViewById(R.id.userMessage);
            aiMessage = itemView.findViewById(R.id.aiMessage);
        }
    }

    public static class LoadingViewHolder extends RecyclerView.ViewHolder {
        TextView appName;
        TextView status;
        ImageView aiThinkIcon;
        ImageView calendarIcon;
        TextView skullText;

        public LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
            appName = itemView.findViewById(R.id.textViewAppName);
            status = itemView.findViewById(R.id.textViewStatus);
            aiThinkIcon = itemView.findViewById(R.id.aiThinkIcon);
            calendarIcon = itemView.findViewById(R.id.calendarIcon);
            skullText = itemView.findViewById(R.id.skullText);
        }
    }

    public static class EventCardViewHolder extends RecyclerView.ViewHolder {
        TextView eventTitle;
        TextView eventTime;
        TextView eventDate;
        TextView eventLocation;
        LinearLayout eventCardContainer;

        public EventCardViewHolder(@NonNull View itemView) {
            super(itemView);
            eventTitle = itemView.findViewById(R.id.eventTitle);
            eventTime = itemView.findViewById(R.id.eventTime);
            eventDate = itemView.findViewById(R.id.eventDate);
            eventLocation = itemView.findViewById(R.id.eventLocation);
            eventCardContainer = itemView.findViewById(R.id.eventCardContainer);
        }
    }
}