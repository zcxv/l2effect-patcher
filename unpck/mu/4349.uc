class 4349 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect30
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.wh_magic_barrier_ta'
		bOnMultiTarget=True
	End Object
	Desc="아지트 매직 배리어" //Magic Barrier hideout
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect30',SpecificStage=0)
}