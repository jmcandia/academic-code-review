from django.urls import path
from catalog.views import item_detail, item_list_create

urlpatterns = [path("items/", item_list_create), path("items/<int:item_id>/", item_detail)]
