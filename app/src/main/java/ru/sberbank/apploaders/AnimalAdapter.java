package ru.sberbank.apploaders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user8 on 20.05.2017.
 */

public class AnimalAdapter extends BaseAdapter{
    List<Animal> animals;

    public AnimalAdapter() {
        animals = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return animals.size();
    }

    @Override
    public Animal getItem(int position) {
        return animals.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = newView(parent);
        }
        bindView(itemView, position);
        return itemView;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals.clear();
        this.animals.addAll(animals);
        notifyDataSetChanged();
    }

    private View newView(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_item, parent, false);
        view.setTag(new ViewHolder(view));
        return view;
    }

    private void bindView(View itemView, int position) {
        ViewHolder holder = (ViewHolder) itemView.getTag();
        Animal animal = animals.get(position);
        Context context = itemView.getContext();
        holder.speciesTextView.setText(composeString(context, R.string.species, animal.getSpecie()));
        holder.heightTextView.setText(composeString(context, R.string.height, String.valueOf(animal.getHeight())));
        holder.nameTextView.setText(composeString(context, R.string.name, animal.getName()));
        holder.weightTextView.setText(composeString(context, R.string.weight, String.valueOf(animal.getMass())));
    }

    private static String composeString(Context context, int propertyResId, String propertyValue) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getString(propertyResId)).append(": ").append(propertyValue);
        return sb.toString();
    }

    private static class ViewHolder {

        public final TextView speciesTextView;

        public final TextView nameTextView;
        public final TextView heightTextView;
        public final TextView weightTextView;

        public ViewHolder(View itemView) {
            speciesTextView = (TextView) itemView.findViewById(R.id.specie);
            heightTextView = (TextView) itemView.findViewById(R.id.height);
            nameTextView = (TextView) itemView.findViewById(R.id.name);
            weightTextView = (TextView) itemView.findViewById(R.id.weight);
        }
    }
}
