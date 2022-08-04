count=$1
for i in $(seq $count); do
	sleep 0.5;
	echo -e "\007";
done
