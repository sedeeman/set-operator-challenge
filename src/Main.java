import java.util.*;


public class Main {

    public static void main(String[] args) {

        Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority).reversed();

        Set<Task> tasks = new HashSet<>(TaskData.getTasks("All"));

        Set<Task> annTasks = new HashSet<>(TaskData.getTasks("Ann"));
        Set<Task> bobTasks = new HashSet<>(TaskData.getTasks("Bob"));
        Set<Task> carolTasks = new HashSet<>(TaskData.getTasks("Carol"));

        List<Set<Task>> taskSets = List.of(annTasks, bobTasks, carolTasks);

        Set<Task> assignedTasks = getUnionTasks(taskSets);
        Set<Task> everyTasks = getUnionTasks(List.of(tasks, assignedTasks));

        sortAndPrint("The true all tasks", everyTasks);

        Set<Task> missingTasks = getDifferenceTasks(everyTasks, tasks);

        sortAndPrint("Missing Tasks", missingTasks);

        Set<Task> unAssignedTasks = getDifferenceTasks(tasks, assignedTasks);

        sortAndPrint("Unassigned Tasks", unAssignedTasks, sortByPriority);

        Set<Task> overLapTasks = getUnionTasks(List.of(
                getInterSectionTasks(annTasks, bobTasks),
                getInterSectionTasks(bobTasks, carolTasks),
                getInterSectionTasks(carolTasks, annTasks)
        ));

        sortAndPrint("Assigned to multiple", overLapTasks, sortByPriority);

        List<Task> overLappingTasks = new ArrayList<>();

        for (Set<Task> set : taskSets) {
            Set<Task> duplicate = getInterSectionTasks(set,overLapTasks);
            overLappingTasks.addAll(duplicate);
        }

        Comparator<Task> sortByNatural = sortByPriority.thenComparing(Comparator.naturalOrder());

        sortAndPrint("Overlapping", overLappingTasks, sortByNatural);

    }

    private static void sortAndPrint(String header, Collection<Task> taskSet) {
        sortAndPrint(header, taskSet, null);
    }

    private static void sortAndPrint(String header, Collection<Task> taskSet, Comparator<Task> sorter) {
        String separator = "_".repeat(90);
        System.out.println(separator);
        System.out.println(header);
        System.out.println(separator);

        List<Task> taskList = new ArrayList<>(taskSet);
        taskList.sort(sorter);
        taskList.forEach(System.out::println);
    }

    private static Set<Task> getUnionTasks(List<Set<Task>> taskSetList) {
        Set<Task> unionTasks = new HashSet<>();

        for (Set<Task> tasks : taskSetList) {
            unionTasks.addAll(tasks);
        }
        return unionTasks;
    }

    private static Set<Task> getInterSectionTasks(Set<Task> aTasks, Set<Task> bTasks) {
        Set<Task> interSectionTasks = new HashSet<>(aTasks);
        interSectionTasks.retainAll(bTasks);
        return interSectionTasks;
    }

    private static Set<Task> getDifferenceTasks(Set<Task> aTasks, Set<Task> bTasks) {
        Set<Task> diffTasks = new HashSet<>(aTasks);
        diffTasks.removeAll(bTasks);
        return diffTasks;
    }

}