package com.example.galaxyaiagent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
        return messageList.get(position).getType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == Message.TYPE_LOADING) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.loading_item, parent, false);
            return new LoadingViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.message_item, parent, false);
            return new MessageViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Message message = messageList.get(position);

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
            // Use the dynamic app name and status
            loadingHolder.appName.setText(MainActivity.currentAppName);
            loadingHolder.status.setText(MainActivity.currentStatus);
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

        public LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
            appName = itemView.findViewById(R.id.textViewAppName);
            status = itemView.findViewById(R.id.textViewStatus);
        }
    }
}