package com.sjava.grpc.client.test;

import java.io.IOException;

import com.sjava.grpc.User.ApiResponse;
import com.sjava.grpc.User.LoginRequest;
import com.sjava.grpc.userGrpc;
import com.sjava.grpc.userGrpc.userBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GRPCClient {

	public static void main(String[] args) throws IOException, InterruptedException {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
		//stubs : - generate from proto
		
		LoginRequest request = LoginRequest.newBuilder().setUsername("Santosh").setPassword("Santosh").build();
		userBlockingStub userStub = userGrpc.newBlockingStub(channel);
		ApiResponse response = userStub.login(request);
		System.out.println("Response from services :: status :- "+response.getResponseCode()+" Response Msg :- "+response.getResponseMessage());
	}

}
