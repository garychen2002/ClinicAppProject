package com.example.clinicappproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;

public class DoctorAppAdapter extends RecyclerView.Adapter<DoctorAppAdapter.MyViewHolder> {

    Context context;
    ArrayList<Appointment> appointmentArrayList;

    public DoctorAppAdapter(Context context, ArrayList<Appointment> appointmentArrayList) {
        this.context = context;
        this.appointmentArrayList = appointmentArrayList;
    }

    @NonNull
    @Override
    public DoctorAppAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_appointment,parent,false);


        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorAppAdapter.MyViewHolder holder, int position) {
        Appointment a = appointmentArrayList.get(position);

        holder.bookingTime.setText(new Date(a.getTime()).toString());
        holder.bookingStatus.setText(a.booking_status());
        holder.patientInfo.setText(a.getPatientInfo());
        holder.preDoctor.setText(a.getPreDoctor());
    }

    @Override
    public int getItemCount() {
        return appointmentArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView bookingTime, bookingStatus, patientInfo, preDoctor;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            bookingTime = itemView.findViewById(R.id.booking_time);
            bookingStatus = itemView.findViewById(R.id.booking_status);
            patientInfo = itemView.findViewById(R.id.p_info);
            preDoctor = itemView.findViewById(R.id.previous_doctor);
        }
    }
}
