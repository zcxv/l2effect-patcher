class 4326 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect18
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.wh_regeneration_ta'
		bOnMultiTarget=True
	End Object
	Desc="초보용 리제네레이션" //Beginner Regeneration
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect18',SpecificStage=0)
}