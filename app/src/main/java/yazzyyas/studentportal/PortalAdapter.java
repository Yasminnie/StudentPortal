package yazzyyas.studentportal;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PortalAdapter extends RecyclerView.Adapter<PortalAdapter.PortalViewHolder> {
    private Context context;
    public List<Portal> PortalList;

    public PortalAdapter(Context context, List<Portal> listPortalObject) {
        this.context = context;
        this.PortalList = listPortalObject;
    }

    @NonNull
    @Override
    public PortalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_cell, parent, false);
        return new PortalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PortalViewHolder holder, int position) {

        final Portal portal = PortalList.get(position);
        holder.portalName.setText(portal.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WebViewActivity.class);
                intent.putExtra("url", portal.getUrl());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return PortalList.size();
    }
}

class PortalViewHolder extends RecyclerView.ViewHolder {
    public TextView portalName;

    public PortalViewHolder(View itemView) {
        super(itemView);

        portalName = itemView.findViewById(R.id.PortalTextView);
    }
}
