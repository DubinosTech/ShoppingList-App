/**
 * @author DubinosTeck
 * Emmanuel Asinyo
 * Brahim Kanouche
 */

package com.dubinosTech.shoppinglistManager.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dubinosTech.shoppinglistManager.R;
import com.dubinosTech.shoppinglistManager.shoppinglist_libraries.ListItem;
import com.dubinosTech.shoppinglistManager.shoppinglist_libraries.ShoppingList;

public class ShoppingListFragment extends Fragment implements EditBar.EditBarListener {

    private EditBar editBar;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerListAdapter adapter;
    private View rootView;
    private ShoppingList shoppingList;

    public static ShoppingListFragment newInstance(ShoppingList shoppingList) {
        ShoppingListFragment fragment = new ShoppingListFragment();
        fragment.setShoppingList(shoppingList);
        return fragment;
    }

    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
        connectList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_shoppinglist, container, false);

        recyclerView = rootView.findViewById(R.id.shoppingListView);
        registerForContextMenu(recyclerView);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration divider = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(divider);

        editBar = new EditBar(rootView, getActivity());
        editBar.addEditBarListener(this);
        editBar.enableAutoHideFAB(recyclerView);

        if (savedInstanceState != null) {
            editBar.restoreState(savedInstanceState);
        }

        return rootView;
    }

    @Override
    public void onDestroyView() {
        editBar.removeEditBarListener(this);
        editBar.hide();
        super.onDestroyView();
    }

    private void connectList() {
        if (shoppingList != null && adapter != null) {
            adapter.connectShoppingList(shoppingList);
        }
        if (shoppingList != null && editBar != null) {
            editBar.connectShoppingList(shoppingList);
        }
    }

    @Override
    public void onStop() {
        adapter.disconnectShoppingList();
        editBar.disconnectShoppingList();
        super.onStop();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new RecyclerListAdapter(getActivity());
        connectList();
        adapter.registerRecyclerView(recyclerView);
        adapter.setOnItemLongClickListener(new RecyclerListAdapter.ItemLongClickListener() {
            @Override
            public boolean onLongClick(int position) {
                ListItem listItem = shoppingList.get(position);
                editBar.showEdit(position, listItem.getDescription(), listItem.getQuantity());
                return true;
            }
        });
        recyclerView.setAdapter(adapter);
    }

    public boolean onBackPressed() {
        if (editBar.isVisible()) {
            editBar.hide();
            return true;
        }
        return false;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        editBar.saveState(outState);
    }

    @Override
    public void onEditSave(int position, String description, String quantity) {
        shoppingList.editItem(position, description, quantity);
        editBar.hide();
        recyclerView.smoothScrollToPosition(position);
    }

    @Override
    public void onNewItem(String description, String quantity) {
        shoppingList.add(description, quantity);
        recyclerView.smoothScrollToPosition(recyclerView.getAdapter().getItemCount() - 1);
    }

    public void removeAllCheckedItems() {
        shoppingList.removeAllCheckedItems();
    }
}
