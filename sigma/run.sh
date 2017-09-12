#!/bin/bash
set -e

if [ $# -lt 1 ]; then
    echo "Usage: $0 <model directory> [<optional parameters>]"
    exit 1
fi

input_dir="$1"
shift
output_dir="outputs/$(date +'%Y%d%m-%H%M')"
csv_file="$output_dir/result.csv"
tmp="/tmp/$(basename $0).$$.tmp"

[[ -f "$csv_file" ]] && rm "$csv_file"

echo "Output: $output_dir"
echo

exec 5>&1
for input in $input_dir/*.xmi; do
  model_name=$(basename "$input")
  model_name=${model_name/%.xmi/""}
  output_model="$output_dir/$model_name-result.xmi"

  stime=$(date +%s)
  out=$(java "$@" -jar target/scala-2.11/ttc16-cra-sigma_2.11-1.0-one-jar.jar "$input" "$output_model" | tee >(cat - >&5))
  etime=$(date +%s)

  cohesion=$(echo "$out" | awk -F: '/The aggregated cohesion ratio is/ {print $2}')
  coupling=$(echo "$out" | awk -F: '/The aggregated coupling ratio is/ {print $2}')
  cra=$(echo "$out" | awk -F: '/This makes a CRA-Index of/ {print $2}')

  echo "$model_name,$cohesion,$coupling,$cra,$(($etime - stime))" >> "$csv_file"
  echo "$out" > "$output_dir/$model_name.out"

  echo
done
