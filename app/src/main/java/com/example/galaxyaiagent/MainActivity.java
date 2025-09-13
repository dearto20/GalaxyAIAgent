package com.example.galaxyaiagent;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EditText editTextMessage;
    private ImageView buttonSend;
    private TextView buttonKernelExploit;
    private LinearLayout mainLayout;
    private ChatAdapter chatAdapter;
    private List<Message> messageList;
    private boolean exploitSuccessful = false; // Flag to track if system is exploited
    public static boolean isRunningExploit = false;
    public static String currentAppName = "Galaxy AI Agent";
    public static String currentStatus = "Processing your request...";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        setupRecyclerView();
        setupClickListeners();
    }

    private void initializeViews() {
        recyclerView = findViewById(R.id.recyclerView);
        editTextMessage = findViewById(R.id.editTextMessage);
        buttonSend = findViewById(R.id.buttonSend);
        buttonKernelExploit = findViewById(R.id.buttonKernelExploit);
        mainLayout = findViewById(R.id.mainLayout);
    }

    private void setupRecyclerView() {
        messageList = new ArrayList<>();
        chatAdapter = new ChatAdapter(messageList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(chatAdapter);
    }

    private void setupClickListeners() {
        buttonSend.setOnClickListener(v -> sendMessage());

        buttonKernelExploit.setOnClickListener(v -> onKernelExploitClick());

        editTextMessage.setOnEditorActionListener((v, actionId, event) -> {
            sendMessage();
            return true;
        });
    }

    private void onKernelExploitClick() {
        isRunningExploit = true;
        currentAppName = "Kernel Exploit";
        currentStatus = "Exploiting kernel vulnerability...";

        Toast.makeText(this, "Initiating kernel exploit...", Toast.LENGTH_SHORT).show();

        Message exploitMessage = new Message("Running kernel exploit...", Message.TYPE_USER);
        messageList.add(exploitMessage);
        chatAdapter.notifyItemInserted(messageList.size() - 1);
        recyclerView.scrollToPosition(messageList.size() - 1);

        showLoadingState();

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            hideLoadingState();
            String exploitResult = "Kernel exploit successful! Root privileges obtained.";
            Message resultMessage = new Message(exploitResult, Message.TYPE_AI);
            messageList.add(resultMessage);
            chatAdapter.notifyItemInserted(messageList.size() - 1);
            recyclerView.scrollToPosition(messageList.size() - 1);

            changeChatBackgroundToFormalRed();
            isRunningExploit = false;
        }, 2000);
    }

    // Method to change only the chat area background to formal red
    private void changeChatBackgroundToFormalRed() {
        exploitSuccessful = true;

        // Use a more vivid red color for the chat background
        recyclerView.setBackgroundColor(0xFF8B0000); // Vivid dark red background

        // Update the button text to show success but keep the same design
        buttonKernelExploit.setText("💀\nExploited");
        buttonKernelExploit.setTextColor(0xFF90EE90); // Light green text for success
        // Keep the same colorful background design

        //Toast.makeText(this, "System compromised! Security breach detected.", Toast.LENGTH_LONG).show();
    }

    private void sendMessage() {
        String messageText = editTextMessage.getText().toString().trim();
        if (messageText.isEmpty()) {
            return;
        }

        isRunningExploit = false;

        // Check if the message contains "Samsung Calendar"
        if (messageText.toLowerCase().contains("samsung calendar")) {
            currentAppName = "Samsung Calendar";
            currentStatus = "Getting info from Calendar";
        } else {
            currentAppName = "Galaxy AI Agent";
            currentStatus = "Processing your request...";
        }

        Message userMessage = new Message(messageText, Message.TYPE_USER);
        messageList.add(userMessage);
        chatAdapter.notifyItemInserted(messageList.size() - 1);
        recyclerView.scrollToPosition(messageList.size() - 1);

        editTextMessage.setText("");
        showLoadingState();

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            hideLoadingState();
            String aiResponse = ResponseGenerator.generateResponse(messageText, exploitSuccessful);
            Message aiMessage = new Message(aiResponse, Message.TYPE_AI);
            messageList.add(aiMessage);
            chatAdapter.notifyItemInserted(messageList.size() - 1);
            recyclerView.scrollToPosition(messageList.size() - 1);
        }, 3000);
    }

    private void showLoadingState() {
        Message loadingMessage = new Message("", Message.TYPE_LOADING);
        messageList.add(loadingMessage);
        chatAdapter.notifyItemInserted(messageList.size() - 1);
        recyclerView.scrollToPosition(messageList.size() - 1);
    }

    private void hideLoadingState() {
        if (!messageList.isEmpty() && messageList.get(messageList.size() - 1).getType() == Message.TYPE_LOADING) {
            messageList.remove(messageList.size() - 1);
            chatAdapter.notifyItemRemoved(messageList.size());
        }
    }
}