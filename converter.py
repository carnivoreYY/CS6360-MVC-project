import csv

with open('books.csv') as f:

  f.readline()
  csv_reader = csv.reader(f, delimiter='\t')
  data = []
  for line_list in csv_reader:
     skills_list = [x.strip() for x in line_list[3].split(',')]
     for skill in skills_list:
        data.append([line_list[1], line_list[2], skill])

return_path = "C:\Users\Ying Yi\Desktop\db_project1\data.csv"
file = open(return_path, 'w')
writer = csv.writer(file)
writer.writerow(["ISBN13", "Title", "Author"])
for i in range(len(data)):
  row = data[i]
  col1 = row[0]
  col2 = row[1]
  col3 = row[2]
  writer.writerow([col1, col2, col3])