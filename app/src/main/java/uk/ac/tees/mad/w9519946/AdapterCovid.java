package uk.ac.tees.mad.w9519946;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.List;

public class AdapterCovid extends RecyclerView.Adapter<AdapterCovid.ViewHolder> {

    int k = 1;
    List<ModelClass> countrylist;
    Context context;

    public AdapterCovid(Context context, List<ModelClass> countrylist) {
        this.countrylist = countrylist;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterCovid.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_covid_layout_item, null, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCovid.ViewHolder holder, int position) {

        ModelClass modelClass = countrylist.get(position);
        if(k==1){
            holder.cases.setText(NumberFormat.getInstance().format(Integer.parseInt(modelClass.getCases())));
        }
        else if (k==2){
            holder.cases.setText(NumberFormat.getInstance().format(Integer.parseInt(modelClass.getRecovered())));
        }
        else if (k==3){
            holder.cases.setText(NumberFormat.getInstance().format(Integer.parseInt(modelClass.getDeaths())));
        }
        else{
            holder.cases.setText(NumberFormat.getInstance().format(Integer.parseInt(modelClass.getActive())));
        }

        holder.country.setText(modelClass.getCountry());

    }

    @Override
    public int getItemCount() {
        return countrylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView cases, country;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            country  = itemView.findViewById(R.id.country_name);
            cases =  itemView.findViewById(R.id.country_cases);
        }
    }

    public void filter(String charText){
        if (charText.equals("cases")){
            k=1;
        }
        else if (charText.equals("recovered"))
        {
            k=2;
        }
        else if (charText.equals("deaths")){
            k=3;
        }
        else {
            k=4;
        }

        notifyDataSetChanged();
    }



}
